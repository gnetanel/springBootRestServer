package hello;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	List<Customer> customerList = new ArrayList<Customer>();
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value="/stringservice/permutate", method = RequestMethod.GET)
    public String permutate(@RequestParam(value="inputString", defaultValue="World") String inputString) {
    	// do permutation here...
    	String permutatedString = getPermutateString(inputString);
	    return permutatedString;
    }

	private static String getPermutateString(String inputString) {
		// permutation done here...
		return "xxx";
	}
	
    @RequestMapping(value="/customer/{id}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable("id")int id) {
    	return customerList.get(0);
    }
    
    @RequestMapping(value="/customer/{id}", method = RequestMethod.PUT)
    public void addCustomer(@PathVariable("id")int id, @RequestBody Customer customer) {
    	customerList.add(customer);
    }
    
//    @RequestMapping(value="/customer/{id}")
//    public Customer getCustomer(int id) {
////    	customerList.add(new Customer("first1", "last1"));
////    	customerList.add(new Customer("first2", "last2"));
//    	return new Customer("xxx", "yyy");
//    	//return customerList[id];
//    }
    
//	
//    @RequestMapping(value="/customer", method = RequestMethod.GET)
//    public List<Customer> getCustomer() {
//    	customerList.add(new Customer("first1", "last1"));
//    	customerList.add(new Customer("first2", "last2"));
//	    return customerList;
//    }
}