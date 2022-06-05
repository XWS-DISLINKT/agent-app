INSERT INTO roles (name) VALUES ('ROLE_ADMIN'),
                                ('ROLE_CLIENT'),
                                ('ROLE_COMPANY_OWNER');

--COMPANIES
INSERT INTO companies (email, employees_number_range, industry, location, name, phone_number, is_approved, about) VALUES
    ('support@company.com', 3, 'Energy', 'Novi Sad', 'Schneider Electric', '+1354312413132', true, 'Cursus turpis massa tincidunt dui. Arcu felis bibendum ut tristique et egestas. Aliquam sem et tortor consequat id porta nibh. Quam lacus suspendisse faucibus interdum posuere lorem ipsum dolor sit. Commodo sed egestas egestas.'),
    ('support@company.com', 5, 'Software Outsourcing', 'Beograd', 'Software Engineering Lab', '+1354312413132', true, 'Arcu odio ut sem nulla pharetra diam sit amet. Vulputate dignissim suspendisse in est ante in nibh mauris. Accumsan in nisl nisi scelerisque eu. Vel quam elementum pulvinar etiam non. Ipsum dolor sit amet consectetur adipiscing elit duis tristique.'),
    ('support@company.com', 6, 'IT', 'Novi Sad', 'Continental', '+1354312413132', false, 'Enim lobortis scelerisque fermentum dui faucibus in ornare quam. Sed viverra tellus in hac. Arcu non sodales neque sodales ut etiam sit. Convallis posuere morbi leo urna. Sit amet dictum sit amet. Elementum facilisis leo vel fringilla est ullamcorper.'),
    ('support@company.com', 4, 'Energy', 'Kragujevac', 'BeeIT', '+1354312413132', false, 'Cursus turpis massa tincidunt dui. Arcu felis bibendum ut tristique et egestas. Aliquam sem et tortor consequat id porta nibh. Quam lacus suspendisse faucibus interdum posuere lorem ipsum dolor sit. Commodo sed egestas egestas.'),
    ('support@company.com', 2, 'Software Outsourcing', 'Beograd', 'SmartCat', '+1354312413132', false, 'Arcu odio ut sem nulla pharetra diam sit amet. Vulputate dignissim suspendisse in est ante in nibh mauris. Accumsan in nisl nisi scelerisque eu. Vel quam elementum pulvinar etiam non. Ipsum dolor sit amet consectetur adipiscing elit duis tristique.');


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
    (101, 5, 2, 1, DATE '2022-05-27', 'Title1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vel fringilla est ullamcorper eget nulla facilisi etiam dignissim. Nisi scelerisque eu ultrices vitae auctor eu.'),
    (102, 4, 3, 1, DATE '2022-05-21', 'Title2', 'Enim lobortis scelerisque fermentum dui faucibus in ornare quam. Sed viverra tellus in hac. Arcu non sodales neque sodales ut etiam sit. Convallis posuere morbi leo urna. Sit amet dictum sit amet. Elementum facilisis leo vel fringilla est ullamcorper.'),
    (103, 4, 3, 1, DATE '2022-04-26', 'Title3', 'Arcu odio ut sem nulla pharetra diam sit amet. Vulputate dignissim suspendisse in est ante in nibh mauris. Accumsan in nisl nisi scelerisque eu. Vel quam elementum pulvinar etiam non. Ipsum dolor sit amet consectetur adipiscing elit duis tristique.'),
    (104, 3, 3, 1, DATE '2022-04-01', 'Title4', 'Cursus turpis massa tincidunt dui. Arcu felis bibendum ut tristique et egestas. Aliquam sem et tortor consequat id porta nibh. Quam lacus suspendisse faucibus interdum posuere lorem ipsum dolor sit. Commodo sed egestas egestas.'),
    (105, 5, 3, 1, DATE '2022-03-31', 'Title5', 'Convallis posuere morbi leo urna molestie at elementum. Congue quisque egestas diam in arcu cursus euismod. Risus nullam eget felis eget nunc lobortis mattis aliquam. Gravida rutrum quisque non tellus orci ac auctor augue.');

INSERT INTO interview_reviews (id, rating, difficulty, author_id, company_id, date_posted, title, selection_process_duration_in_weeks, hr_interview, technical_interview) VALUES
     (101, 5, 0, 2, 1, DATE '2022-05-27', 'Title1', 2.7, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vel fringilla est ullamcorper eget nulla facilisi etiam dignissim. Nisi scelerisque eu ultrices vitae auctor eu.', 'Convallis posuere morbi leo urna molestie at elementum. Congue quisque egestas diam in arcu cursus euismod. Risus nullam eget felis eget nunc lobortis mattis aliquam. Gravida rutrum quisque non tellus orci ac auctor augue.'),
     (102, 4, 1, 3, 1, DATE '2022-05-21', 'Title2', 3.4, 'Cursus turpis massa tincidunt dui. Arcu felis bibendum ut tristique et egestas. Aliquam sem et tortor consequat id porta nibh. Quam lacus suspendisse faucibus interdum posuere lorem ipsum dolor sit. Commodo sed egestas egestas.', 'Enim lobortis scelerisque fermentum dui faucibus in ornare quam. Sed viverra tellus in hac. Arcu non sodales neque sodales ut etiam sit. Convallis posuere morbi leo urna. Sit amet dictum sit amet. Elementum facilisis leo vel fringilla est ullamcorper.'),
     (103, 5, 2, 3, 1, DATE '2022-04-26', 'Title3', 3.1, 'Arcu odio ut sem nulla pharetra diam sit amet. Vulputate dignissim suspendisse in est ante in nibh mauris. Accumsan in nisl nisi scelerisque eu. Vel quam elementum pulvinar etiam non. Ipsum dolor sit amet consectetur adipiscing elit duis tristique.', 'Cursus turpis massa tincidunt dui. Arcu felis bibendum ut tristique et egestas. Aliquam sem et tortor consequat id porta nibh. Quam lacus suspendisse faucibus interdum posuere lorem ipsum dolor sit. Commodo sed egestas egestas.');

INSERT INTO jobs (id, position, seniority, company_id, location, closing_date, description) VALUES
    (101, 'Full Stack Developer', 0, 1, 'Novi Sad', DATE '2022-08-08', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Vel fringilla est ullamcorper eget nulla facilisi etiam dignissim. Nisi scelerisque eu ultrices vitae auctor eu.'),
    (102, 'Java Developer', 1, 1, 'Remote', DATE '2022-06-30', 'Cursus turpis massa tincidunt dui. Arcu felis bibendum ut tristique et egestas. Aliquam sem et tortor consequat id porta nibh. Quam lacus suspendisse faucibus interdum posuere lorem ipsum dolor sit. Commodo sed egestas egestas.'),
    (103, 'DevOps Engineer', 2, 1, 'Beograd', DATE '2022-07-15', 'Arcu odio ut sem nulla pharetra diam sit amet. Vulputate dignissim suspendisse in est ante in nibh mauris. Accumsan in nisl nisi scelerisque eu. Vel quam elementum pulvinar etiam non. Ipsum dolor sit amet consectetur adipiscing elit duis tristique.');

INSERT INTO salary_reviews (id, position, seniority, company_id ,monthly_salary_eur) VALUES
    (101, 'Full Stack Developer', 0, 1, 900),
    (102, 'Java Developer', 0, 1,  900),
    (103, 'DevOps Engineer', 2, 1, 2500),
    (104, 'Full Stack Developer', 0, 1, 800),
    (105, 'Java Developer', 1, 1,  1600),
    (106, 'Test Developer', 1, 1, 700),
    (107, 'Full Stack Developer', 0, 1, 1100),
    (108, 'Java Developer', 2, 1,  2000),
    (109, 'DevOps Engineer', 2, 1, 2400),
    (110, 'Full Stack Developer', 2, 1, 1900),
    (111, 'Java Developer', 2, 1,  2200),
    (112, 'DevOps Engineer', 2, 1, 2600);
