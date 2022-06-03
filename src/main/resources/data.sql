INSERT INTO roles (name) VALUES ('ROLE_ADMIN'),
                                ('ROLE_CLIENT'),
                                ('ROLE_COMPANY_OWNER');

--COMPANIES
INSERT INTO companies (email, employees_number_range, industry, location, name, phone_number, is_approved, about) VALUES
    ('support@company.com', 3, 'Energy', 'Novi Sad', 'Schneider Electric', '+1354312413132', true, 'long string'),
    ('support@company.com', 5, 'Software Outsourcing', 'Beograd', 'Software Engineering Lab', '+1354312413132', true, 'long string'),
    ('support@company.com', 4, 'IT', 'Novi Sad', 'Continental', '+1354312413132', false, 'long string');


--USERS
INSERT INTO users (email, password) VALUES
    ('admin@gmail.com', '$2a$10$pJh4JIroHGMYkadZySbh9uHYTt4kuW2pMHlxd/Pdtw/RIFnClvpgy'),
    ('client1@gmail.com', '$2a$10$pJh4JIroHGMYkadZySbh9uHYTt4kuW2pMHlxd/Pdtw/RIFnClvpgy'),
    ('client2@gmail.com', '$2a$10$pJh4JIroHGMYkadZySbh9uHYTt4kuW2pMHlxd/Pdtw/RIFnClvpgy');
INSERT INTO users (email, password, company_id) VALUES
    ('owner@gmail.com', '$2a$10$pJh4JIroHGMYkadZySbh9uHYTt4kuW2pMHlxd/Pdtw/RIFnClvpgy', 1);

INSERT INTO users_roles (user_id, roles_id) VALUES (1, 1),
                                                   (2, 2),
                                                   (3, 2),
                                                   (4, 3);


INSERT INTO comments (id, rating, author_id, company_id, date_posted, title, content) VALUES
    (101, 3, 2, 1, DATE '2022-05-27', 'title1', 'cont1'),
    (102, 4, 3, 1, DATE '2022-05-21', 'title2', 'cont2');
