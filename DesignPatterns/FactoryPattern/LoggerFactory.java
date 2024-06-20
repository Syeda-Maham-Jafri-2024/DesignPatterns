// You are tasked with developing a logging system for a software application that requires a centralized logger factory. 
// The system must ensure that there is a single point of access to logging functionality throughout the application's lifecycle. 
// Each logger type (e.g., file logger, console logger) can be dynamically created, and these loggers should seamlessly integrate with
//  the existing logging infrastructure.

// Requirements:

// There should be a single logger factory responsible for creating and managing all logger instances.
// The logger factory should provide methods to create loggers of different types.
// Loggers can have various configurations, such as log levels and output destinations.
// The system must support concurrent logging operations from different parts of the application.
// The logger factory should support lazy initialization to optimize resource usage.
// Challenges:

// The logger instances must be globally accessible, ensuring that any component in the application can log messages using the current logger configuration.
// It should be possible to extend the system by adding new logger types without modifying the existing code.
public class LoggerFactory{
    public static void main(String[] args){

    }
}
interface logger{
    public void getloggertype(){};
    
}