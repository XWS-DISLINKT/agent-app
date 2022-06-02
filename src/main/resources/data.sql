INSERT INTO roles (name) VALUES ('ROLE_ADMIN'),
                                ('ROLE_CLIENT'),
                                ('ROLE_COMPANY_OWNER');

--COMPANIES
INSERT INTO companies (id, email, employees_number_range, industry, location, name, phone_number, is_approved, about) VALUES
    (1, 'support@company.com', 3, 'Energy', 'Novi Sad', 'Schneider Electric', '+1354312413132', true, 'long string'),
    (2, 'support@company.com', 5, 'Software Outsourcing', 'Beograd', 'Software Engineering Lab', '+1354312413132', false, 'long string'),
    (3, 'support@company.com', 4, 'IT', 'Novi Sad', 'Continental', '+1354312413132', false, 'long string');



--USERS
INSERT INTO users (id, email, password, company_id) VALUES
    (4, 'owner@gmail.com', '$2a$10$pJh4JIroHGMYkadZySbh9uHYTt4kuW2pMHlxd/Pdtw/RIFnClvpgy', 1);
INSERT INTO users (id, email, password) VALUES
    (1, 'admin@gmail.com', '$2a$10$pJh4JIroHGMYkadZySbh9uHYTt4kuW2pMHlxd/Pdtw/RIFnClvpgy'),
    (2, 'client1@gmail.com', '$2a$10$pJh4JIroHGMYkadZySbh9uHYTt4kuW2pMHlxd/Pdtw/RIFnClvpgy'),
    (3, 'client2@gmail.com', '$2a$10$pJh4JIroHGMYkadZySbh9uHYTt4kuW2pMHlxd/Pdtw/RIFnClvpgy');

INSERT INTO users_roles (user_id, roles_id) VALUES (1, 1),
                                                   (2, 2),
                                                   (3, 2),
                                                   (4, 3);