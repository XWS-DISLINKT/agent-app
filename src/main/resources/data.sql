INSERT INTO roles (name) VALUES ('ROLE_ADMIN'),
                                ('ROLE_CLIENT'),
                                ('ROLE_COMPANY_OWNER');

INSERT INTO users (id, email, password) VALUES
       (1, 'admin@gmail.com', '$2a$10$pJh4JIroHGMYkadZySbh9uHYTt4kuW2pMHlxd/Pdtw/RIFnClvpgy'),
       (2, 'client1@gmail.com', '$2a$10$pJh4JIroHGMYkadZySbh9uHYTt4kuW2pMHlxd/Pdtw/RIFnClvpgy'),
       (3, 'client2@gmail.com', '$2a$10$pJh4JIroHGMYkadZySbh9uHYTt4kuW2pMHlxd/Pdtw/RIFnClvpgy'),
       (4, 'owner@gmail.com', '$2a$10$pJh4JIroHGMYkadZySbh9uHYTt4kuW2pMHlxd/Pdtw/RIFnClvpgy');

INSERT INTO users_roles (user_id, roles_id) VALUES (1, 1),
                                                   (2, 2),
                                                   (3, 2),
                                                   (4, 3);