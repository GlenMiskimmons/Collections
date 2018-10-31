package com.pluralsight.collections._5_queues.a_queues;

import com.pluralsight.collections._5_queues.Category;
import com.pluralsight.collections._5_queues.Customer;
import com.pluralsight.collections._5_queues.Enquiry;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

public class CategorisedHelpDesk {
    private final Queue<Enquiry> enquiries = new ArrayDeque<>();

    public static void main(String[] args) {
        CategorisedHelpDesk helpDesk = new CategorisedHelpDesk();

        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);

        helpDesk.processPrinterEnquiry();
        helpDesk.processGeneralEnquiry();
        helpDesk.processPrinterEnquiry();
    }

    public void enquire(final Customer customer, final Category category) {
        enquiries.offer(new Enquiry(customer, category));
    }

    public void processPrinterEnquiry() {
        processEnquiry(enq -> enq.getCategory() == Category.PRINTER, "Is is out of paper?");
    }

    public void processGeneralEnquiry() {
        processEnquiry(enq -> enq.getCategory() != Category.PRINTER, "Have you tried turning it off and on again?");
    }

    public void processEnquiry(Predicate<Enquiry> predicate, String message) {
        final Enquiry enquiry = enquiries.peek();
        if(enquiry != null && predicate.test(enquiry)) {
            enquiries.remove();
            enquiry.getCustomer().reply(message);
        } else {
            System.out.println("No work to do, lets have some coffee!");
        }
    }
}
