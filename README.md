# CS 305 Portfolio Reflection - Project Two: Practices for Secure Software

This repository contains artifacts and reflections from CS 305: Software Security. The primary artifact included is the **Practices for Secure Software Report**, completed as part of Project Two.

## Project Reflection

### Client Summary

The client for this project was **Artemis Financial**, a consulting company specializing in individualized financial plans (including savings, retirement, investments, and insurance). Artemis Financial sought to modernize its operations and required expertise in implementing up-to-date, robust software security for its public web interface to protect sensitive client data. Specifically, they requested the addition of a **file verification step (checksum)** and the implementation of **secure communication protocols (HTTPS)** for their existing software application.

### Secure Coding Practices and Value

During this project, I successfully identified and addressed security vulnerabilities by refactoring the client's codebase. A key strength was the systematic approach to implementing **cryptographic controls** and **secure transport layers**. I recommended and deployed SHA-256 for checksum verification and configured the server for HTTPS using a self-signed certificate generated with Java Keytool.

Coding securely is crucial, especially when handling sensitive financial information like Artemis Financial does. It prevents data breaches, ensures data integrity, and protects against unauthorized access. Integrating security throughout the development lifecycle, as advocated by Secure SDLC models, is essential for delivering trustworthy software. Software security adds immense value by **mitigating risks** (financial loss, legal liability), **building customer trust**, enhancing the company's **reputation**, and ultimately **protecting the company's bottom line**. Fixing vulnerabilities during development is far more cost-effective than dealing with the aftermath of a security incident.

### Challenges and Helpful Aspects

The most helpful part of the vulnerability assessment process was understanding the **layered security approach**. Implementing both data integrity checks (checksums) and data-in-transit protection (HTTPS) provided a practical understanding of defense-in-depth. Generating a self-signed certificate with Java Keytool and configuring Spring Boot application properties were also valuable hands-on experiences. A challenging aspect was troubleshooting the initial setup, particularly ensuring the Java code had the necessary dependencies (`jaxb-api`, `jaxb-runtime`) and that the server could correctly locate and use the generated keystore file. While expertise and education play a role in assessment accuracy, specific system knowledge and individual characteristics can be equally important.

### Increasing Security Layers and Future Assessments

Layers of security were increased by:
1.  **Implementing Data Integrity**: Adding the SHA-256 checksum mechanism to verify file integrity.
2.  **Enforcing Confidentiality**: Converting the application protocol from HTTP to HTTPS using TLS/SSL encryption.
3.  **Verifying Dependencies**: Using a static analysis tool (OWASP Dependency-Check) as part of the testing phase common in Secure Development Lifecycles.

In the future, I would continue to use a combination of **manual code review** (focusing on secure coding principles like input validation, proper error handling, and secure configuration), **Static Application Security Testing (SAST)** tools like OWASP Dependency-Check or SonarQube integrated into the CI/CD pipeline, and potentially **Dynamic Application Security Testing (DAST)** tools for assessing the running application. These testing activities are crucial components of a comprehensive SDL. The choice of mitigation techniques would be guided by risk assessment frameworks (such as the OWASP Top 10) and the specific context of the application's threats.

### Ensuring Functionality and Security

Functionality was ensured through iterative testing. After each code refactoring step (adding the hash endpoint, configuring SSL), the application was compiled and run (`./mvnw spring-boot:run`) to verify it started correctly and the endpoint (`/hash`) produced the expected output over the correct protocol (`https://`).

Security, particularly the absence of *new* vulnerabilities introduced by the refactoring, was checked using the **OWASP Dependency-Check Maven plugin**. After completing the code changes, I ran the `dependency-check:check` goal. The resulting report confirmed that no dependencies with known vulnerabilities were included in the project. Manual code review also focused on ensuring the added code didn't introduce common flaws, such as injection vulnerabilities (which were mitigated by hashing a static string). These checks align with the testing and verification activities within a typical SDL.

### Helpful Resources and Practices

Several resources and practices were invaluable:
* **Java Keytool**: For generating SSL/TLS certificates.
* **Spring Boot `application.properties`**: For configuring SSL/TLS settings easily.
* **Java `MessageDigest` Class**: For implementing standard cryptographic hash functions.
* **OWASP Dependency-Check**: An invaluable tool for managing third-party library vulnerabilities.
* **Secure Coding Principles**: Concepts from resources like "Iron-Clad Java" regarding HTTPS and vulnerability management.
* **Understanding the Secure SDLC**: Recognizing how specific activities like dependency checking fit into a larger security process.
These tools and practices will definitely be helpful for future software development tasks that require secure implementation.

### Portfolio Showcase

In this assignment, I will present the completed **Practices for Secure Software Report** as the primary artifact to future employers. This report demonstrates:
* My ability to analyze security requirements.
* Knowledge of cryptographic principles (hashing, encryption, certificates).
* Practical skills in implementing HTTPS in a Java Spring Boot application.
* Experience using security tools like Java Keytool and OWASP Dependency-Check.
* My understanding of industry-standard best practices for secure coding within a development lifecycle context.
The **refactored code itself** could also be presented to show concrete implementation details.

### References

Allodi, L., Cremonini, M., Massacci, F., & Shim, W. (2018). *The Effect of Security Education and Expertise on Security Assessments: The Case of Software Vulnerabilities*. arXiv. [https://arxiv.org/abs/1808.06547](https://arxiv.org/abs/1808.06547)

Manico, J., & Detlefsen, A. (2015). *Iron-clad Java: Building secure web applications*. McGraw-Hill Education.

Oracle. (n.d.-a). *keytool - Key and Certificate Management Tool*. Java SE Documentation.

Oracle. (n.d.-b). *Java Security Standard Algorithm Names*. Java SE Documentation.

OWASP. (n.d.). *dependency-check-maven – Usage*. OWASP Foundation.

Romeo, C. (201?). *Secure Development Lifecycle: The essential guide to safe software pipelines*. Security Journey.

Synopsys Editorial Team. (202?). *Secure SDLC 101: Mastering software development life cycle security*. Synopsys.

Southern New Hampshire University. (n.d.-a). *CS 305 Integrating the Maven Dependency-Check Plugin Tutorial*.

Southern New Hampshire University. (n.d.-b). *How to Create a Self-Signed Certificate using Java Keytool*.

Southern New Hampshire University. (n.d.-c). *Vulnerability Assessment Process Flow Diagram*.
