package priv.sin.librarylabsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class LibraryLabsProjectApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(LibraryLabsProjectApplication.class);
		ApplicationContext context = app.run(args);


		// Start a separate thread to listen for the Esc key
		new Thread(() -> {
			System.out.println("Type 'zero' key to exit the application...");
			try {
				while (true) {
					int key = System.in.read();
					// ASCII code for ESC is 27
					if (key == 48) {
						System.out.println("Shutting down...");
						SpringApplication.exit(context);
						System.exit(0);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}
}
