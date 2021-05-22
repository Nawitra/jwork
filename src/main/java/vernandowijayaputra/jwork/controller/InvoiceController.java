package vernandowijayaputra.jwork.controller;

import org.springframework.web.bind.annotation.*;
import vernandowijayaputra.jwork.*;

import java.util.ArrayList;

@RequestMapping("/invoice")
@RestController
public class InvoiceController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Invoice> getAllInvoice() {
        return DatabaseInvoice.getInvoiceDatabase();
    }

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

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Invoice addBankPayment(
            @RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
            @RequestParam(value = "jobseekerId") int jobseekerId,
            @RequestParam(value = "adminFee") int adminFee

    ) throws JobSeekerNotFoundException {
        ArrayList<Job> job = null;
        for (Integer integer : jobIdList) {
            try {
                job.add(DatabaseJob.getJobById(integer));
            } catch (JobNotFoundException e) {
                e.getMessage();
            }
        }
        Invoice invoice = new BankPayment(DatabaseInvoice.getLastId() + 1,
                job,
                DatabaseJobseeker.getJobseekerById(jobseekerId), adminFee);
        Boolean status = null;
        try {
            invoice.setTotalFee();
            status = DatabaseInvoice.addInvoice(invoice);
        } catch (OngoingInvoiceAlreadyExistsException error) {
            error.getMessage();
            return null;
        }
        return status ? invoice : null;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Invoice addEWalletPayment(
            @RequestParam(value = "jobIdList") ArrayList<Integer> jobIdList,
            @RequestParam(value = "jobseekerID") int jobseekerId,
            @RequestParam(value = "referralCode") String referralCode

    ) throws JobSeekerNotFoundException {
        ArrayList<Job> job = null;
        for (Integer integer : jobIdList) {
            try {
                job.add(DatabaseJob.getJobById(integer));
            } catch (JobNotFoundException e) {
                e.getMessage();
            }
        }
        Invoice invoice = new EwalletPayment(DatabaseInvoice.getLastId() + 1,
                job,
                DatabaseJobseeker.getJobseekerById(jobseekerId),
                DatabaseBonus.getBonusByReferralCode(referralCode));
        Boolean status = null;
        try {
            invoice.setTotalFee();
            status = DatabaseInvoice.addInvoice(invoice);
        } catch (OngoingInvoiceAlreadyExistsException error) {
            error.getMessage();
            return null;
        }
        return status ? invoice : null;
    }
}
