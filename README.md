## Reflection

### How can I ensure that my code, program, or software is functional and secure?

I ensure functionality and security by building in validation, testing, and clear boundaries between trusted and untrusted data from the start. Functionality comes from writing small, testable units of logic and verifying them with repeatable tests such as unit tests for core rules and integration tests for key workflows. I also rely on defensive programming by validating inputs, handling edge cases, and failing safely with meaningful error messages instead of crashing or producing incorrect results. To keep behavior consistent, I use version control with frequent commits and careful review of changes to confirm new updates do not break existing features.

Security requires treating every external input as potentially unsafe and minimizing what the program exposes. I focus on proper authentication and authorization to ensure only the correct users can access specific data. I use secure password storage methods such as hashing and salting, and I avoid hard coding sensitive information by using environment variables. I also apply the principle of least privilege, sanitize and validate user input, and use parameterized queries to prevent injection attacks. In addition, I keep dependencies updated, monitor for known vulnerabilities, and document security assumptions to prevent accidental weaknesses in future updates.

---

### How do I interpret user needs and incorporate them into a program?

I begin by translating user needs into clear goals and measurable requirements. I ask what problem the user is trying to solve, what success looks like, and what actions they need to perform most often. From there, I break the problem into user stories that describe who the user is, what they want to do, and why. These stories are then mapped into features and workflows. I prioritize high value features first, build a simple version, and improve it through iteration and feedback.

To incorporate user needs effectively, I focus on usability and constraints. I design the interface and program flow to match how users naturally approach tasks, using clear labels and simple navigation. I include helpful features such as meaningful error messages, sensible defaults, and input validation to reduce confusion. When user needs conflict, such as simplicity versus flexibility, I design a system that is easy to use by default while still allowing advanced options for more experienced users.

---

### How do I approach designing software?

My design process begins with defining the problem, identifying the users, and outlining key requirements and constraints. I then create a high level architecture that separates responsibilities into layers such as user interface, business logic, and data access. This helps ensure the system is organized and easier to maintain. I aim for a modular design where each component has a clear purpose and can be tested or updated independently.

After establishing the structure, I design the data model and workflows. I consider how information flows through the system, what needs to be stored, and what rules ensure accuracy. I then implement features in small increments, testing and refining each step before moving forward. Throughout the process, I focus on maintainability by using clear naming, consistent formatting, and helpful documentation. This approach results in software that is reliable, scalable, and aligned with user needs over time.
