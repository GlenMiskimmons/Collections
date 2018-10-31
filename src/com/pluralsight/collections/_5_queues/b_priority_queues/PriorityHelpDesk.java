package com.pluralsight.collections._5_queues.b_priority_queues;

import com.pluralsight.collections._5_queues.Category;
import com.pluralsight.collections._5_queues.Customer;
import com.pluralsight.collections._5_queues.Enquiry;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityHelpDesk {
    private static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {
        @Override
        public int compare(Enquiry o1, Enquiry o2) {
            return o1.getCategory().compareTo(o2.getCategory());
        }
    };
    private final Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);

    public static void main(String[] args) {
        PriorityHelpDesk helpDesk = new PriorityHelpDesk();

        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, Category.PRINTER);
        helpDesk.enquire(Customer.MARY, Category.COMPUTER);

        helpDesk.processAllEnquiries();
    }

    public void enquire(final Customer customer, final Category category) {
        enquiries.offer(new Enquiry(customer, category));
    }

    public void processAllEnquiries() {
        Enquiry enquiry;

        while((enquiry = enquiries.poll()) != null) {
            enquiry.getCustomer().reply("Have you tried turning it off and on again");
        }

//        while(!enquiries.isEmpty()) {
//            final Enquiry enquiry = enquiries.remove();
//            enquiry.getCustomer().reply("Have you tried turning it off and on again");
//        }
    }
}
