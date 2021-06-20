package vernandowijayaputra.jwork.controller;

import org.springframework.web.bind.annotation.*;
import vernandowijayaputra.jwork.*;

import java.util.ArrayList;

/**
 * Class yang digunakan untuk menangani methods yang berkaitan dengan invoice
 *
 * @author Vernando Wijaya Putra
 * @version 2021.06.07
 */
@RequestMapping("/invoice")
@RestController
public class InvoiceController {
    /**
     * Method yang digunakan untuk mendapatkan database invoice
     *
     * @return semua entry dari database invoice
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoice.getInvoiceDatabase();
    }

    /**
     * Method yang digunakan untuk mendapatkan invoice berdasarkan id yang diberikan
     *
     * @param id sebagai id acuan untuk mendapatkan invoice
     * @return objek invoice
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Invoice getInvoiceById(@PathVariable int id) {
        Invoice invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceById(id);
        } catch (InvoiceNotFoundException error) {
            error.getMessage();
            return null;
        }
        return invoice;
    }

    /**
     * Method yang digunakan untuk mendapatkan invoice melalui jobseekerId
     *
     * @param jobseekerId sebagai id acuan untuk mendapatkan invoice
     * @return objek invoice
     */
    @RequestMapping(value = "/jobseeker/{jobseekerId}", method = RequestMethod.GET)
    public ArrayList<Invoice> getInvoiceByJobseekerId(@PathVariable int jobseekerId) {
        ArrayList<Invoice> invoice = null;
        try {
            invoice = DatabaseInvoice.getInvoiceByJobseeker(jobseekerId);
        } catch (Exception error) {
            error.printStackTrace();
        }
        return invoice;
    }

    /**
     * Method yang digunakan untuk mengubah status dari suatu invoice
     *
     * @param id merupakan id dari invoice yang ingin diubah statusnya
     * @param status sebagai status baru dari invoice
     * @return objek invoice yang statusnya telah diganti
     */
    @RequestMapping(value = "/invoiceStatus/{id}", method = RequestMethod.PUT)
    public Invoice changeInvoiceStatus(@RequestParam(value = "id") int id,
                                       @RequestParam(value = "status") InvoiceStatus status) {
        try {
            Invoice invoice = DatabaseInvoice.getInvoiceById(id);
            invoice.setInvoiceStatus(status);
            return invoice;
        } catch (InvoiceNotFoundException error) {
            error.getMessage();
            return null;
        }
    }

    /**
     * Method yang digunakan untuk menghapus suatu invoice dari database
     *
     * @param id merupakan id dari invoice yang ingin dihapus
     * @return true bila berhasil, false bila gagal
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean removeInvoice(@RequestParam(value = "id") int id) {
        try {
            DatabaseInvoice.removeInvoice(id);
        } catch (InvoiceNotFoundException error) {
            error.getMessage();
            return false;
        }
        return true;
    }

    /**
     * Method yang digunakan untuk membuat invoice baru dengan tipe pembayaran bank
     *
     * @param jobIdList merupakan list yang job
     * @param jobseekerId merupakan id dari jobseeker
     * @param adminFee menyimpan nilai admin fee
     * @return invoice yang telah dibuat bila berhasil, null bila gagal
     * @throws JobSeekerNotFoundException
     */
    @RequestMapping(value = "/createBankPayment", method = RequestMethod.POST)
    public Invoice addBankPayment(
            @RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
            @RequestParam(value = "jobseekerId") int jobseekerId,
            @RequestParam(value = "adminFee") int adminFee

    ) throws JobSeekerNotFoundException {
        Invoice invoice = null;
        ArrayList<Job> jobs = new ArrayList<>();
        for (Integer integer : jobIdList) {
            jobs.add(DatabaseJobPostgre.getJobById(integer));
        }
        invoice = new BankPayment(DatabaseInvoice.getLastId() + 1, jobs, DatabaseJobseekerPostgre.getJobseekerById(jobseekerId), adminFee);
        invoice.setTotalFee();
        boolean status = false;
        try {
            status = DatabaseInvoice.addInvoice(invoice);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.printStackTrace();
        }
        return status ? invoice : null;
    }

    /**
     * Method yang digunakan untuk membuat invoice baru dengan tipe pembayaran e-wallet
     *
     * @param jobIdList merupakan list yang menyimpan job
     * @param jobseekerId merupakan id dari jobseeker
     * @param referralCode menyimpan referral code
     * @return objek invoice yang telah dibuat bila berhasil, null bila gagal
     */
    @RequestMapping(value = "/createEWalletPayment", method = RequestMethod.POST)
    public Invoice addEWalletPayment(@RequestParam(value="jobIdList")ArrayList<Integer> jobIdList,
                                     @RequestParam(value="jobseekerId") int jobseekerId,
                                     @RequestParam(value="referralCode", defaultValue="None") String referralCode)
    {
        System.out.println(jobIdList);
        EwalletPayment wallet = null;
        ArrayList<Job> jobs = new ArrayList<Job>();
        for(int id : jobIdList)
        {
            jobs.add(DatabaseJobPostgre.getJobById(id));
        }

        wallet = new EwalletPayment(DatabaseInvoice.getLastId() + 1, jobs,
                DatabaseJobseekerPostgre.getJobseekerById(jobseekerId),
                DatabaseBonusPostgre.getBonusByReferralCode(referralCode));
        wallet.setTotalFee();

        try {
            DatabaseInvoice.addInvoice(wallet);
        } catch (OngoingInvoiceAlreadyExistsException e) {
            e.getMessage();
            return null;
        }

        return wallet;
    }
}