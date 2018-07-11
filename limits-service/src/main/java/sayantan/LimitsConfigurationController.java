package sayantan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
public class LimitsConfigurationController {

	@Autowired
	Configuration configuration;
	
	@GetMapping("/limits")
	public LimitsConfiguration retriveLimitsFromConfigurations() {
		
		return new LimitsConfiguration(configuration.getMinimum(), configuration.getMaximum());
	}
	
	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod="fallbackRetriveConfiguration")
	public LimitsConfiguration retriveConfiguration() {
		
		return new LimitsConfiguration(configuration.getMinimum(), configuration.getMaximum());
	}
	
	
	public LimitsConfiguration fallbackRetriveConfiguration() {
		
		return new LimitsConfiguration(9, 999);
	}
}
