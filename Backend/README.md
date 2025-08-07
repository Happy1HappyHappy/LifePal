# diary-app

## Note(To be edited)
### Why not choose firebase but PostgreSQL?
In building this diary application, we selected PostgreSQL as the primary database over alternatives like Firebase Firestore for the following reasons:

✅ 1. Structured, Relational Data Model

This app handles multiple relational entities such as:
•	Users and their associated diary entries
•	Tags and moods connected to each entry
•	Filters and sorting based on timestamps or content

PostgreSQL, as a relational database, is well-suited for representing these clear relationships and constraints using foreign keys, indexes, and transactions.

📌 For example: a diary entry belongs to a user, and may contain many tags — this is easily modeled with normalized SQL tables.

⸻

✅ 2. Powerful Query Capabilities

The app supports:
•	Full-text search (title or content with keywords)
•	Filtering by mood or tag
•	Sorting by creation or update time

PostgreSQL’s advanced SQL support and indexing capabilities make these queries fast, expressive, and scalable, while Firebase’s NoSQL model would require workarounds or client-side filtering for similar tasks.

⸻

✅ 3. Data Integrity & Transactions

PostgreSQL supports ACID-compliant transactions, which are critical for maintaining consistent state — especially when adding or deleting multiple related entities (e.g., a diary entry and its tags).

Firebase Firestore, while flexible, offers eventual consistency and lacks robust transaction support across multiple documents, which can lead to race conditions in more complex workflows.

⸻

✅ 4. Production-Ready and Scalable

PostgreSQL is battle-tested in production environments and:
•	Easily supports scaling through cloud services (e.g. Supabase, Neon, RDS)
•	Has strong support for migrations, backups, monitoring, and tuning

For long-term maintainability and professional-grade development, PostgreSQL provides more control and reliability.

⸻

❌ Why Not Firebase?

While Firebase is an excellent tool for quick prototyping, mobile-first apps, or realtime sync needs, it has key limitations:
•	Limited querying (no JOINs, complex filters are hard)
•	No relational enforcement
•	Tight client dependency (logic shifts to frontend)

This app’s design benefits more from a strong backend, RESTful architecture, and relational integrity — which PostgreSQL enables seamlessly with Spring Boot and JPA.

⸻

✅ Conclusion

PostgreSQL complements this application’s architecture, which emphasizes:
•	Clean separation of concerns
•	Server-side control
•	Scalable data modeling
•	Industry-standard development patterns

It also reflects real-world backend experience, which is valuable for engineering interviews and long-term team collaboration.