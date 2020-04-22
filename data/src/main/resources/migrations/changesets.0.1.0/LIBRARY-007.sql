-- Adding new columns created_by, updated_by, created_at, updated_at and triggers

-- Trigger function for updated_at
CREATE OR REPLACE FUNCTION update_modified_column()
RETURNS TRIGGER AS $$
BEGIN
   IF row(NEW.*) IS DISTINCT FROM row(OLD.*) THEN
      NEW.updated_at = now();
      RETURN NEW;
   ELSE
      RETURN OLD;
   END IF;
END;
$$ language 'plpgsql';

-- users
ALTER TABLE users
    ADD COLUMN created_by INTEGER NOT NULL DEFAULT '1',
    ADD COLUMN updated_by INTEGER NULL,
    ADD COLUMN created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ADD COLUMN updated_at TIMESTAMP NULL,
    ADD COLUMN active_flg BOOL NOT NULL DEFAULT 'Y';

ALTER TABLE users
    ALTER COLUMN created_by DROP DEFAULT;

-- Trigger updated_at for users
CREATE TRIGGER users_updated_at_fill BEFORE UPDATE ON users FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

-- Duplicate user with id=1
INSERT INTO users (
	first_name, last_name, middle_name, username, password, role_id, created_by, updated_by, created_at, updated_at, active_flg
)
(select
	 first_name, last_name, middle_name, username, password, role_id, created_by, updated_by, created_at, updated_at, active_flg
from users where user_id=1);

-- Delete user with id=1
DELETE FROM users WHERE user_id=1;

-- Add Admin user
INSERT INTO users (user_id, first_name, username, password, role_id, created_by)
VALUES (1, 'Admin', 'Admin', 'Admin', 1, 1);

-- Duplicate user with id=2
INSERT INTO users (
    first_name, last_name, middle_name, username, password, role_id, created_by, updated_by, created_at, updated_at, active_flg
)
(select
    first_name, last_name, middle_name, username, password, role_id, created_by, updated_by, created_at, updated_at, active_flg
from users where user_id=2);

-- Delete user with id=2
DELETE FROM users WHERE user_id=2;

-- Add Guest user
INSERT INTO users (user_id, first_name, username, password, role_id, created_by)
VALUES (2, 'Guest', 'Guest', 'Guest', 1, 1);

-- books
ALTER TABLE books
    ADD COLUMN created_by INTEGER NOT NULL DEFAULT '1',
    ADD COLUMN updated_by INTEGER NULL,
    ADD COLUMN created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ADD COLUMN updated_at TIMESTAMP NULL,
    ADD COLUMN paper_book_available_flg BOOL NOT NULL DEFAULT 'N';

ALTER TABLE books
    ALTER COLUMN created_by DROP DEFAULT;

-- Trigger updated_at for books
CREATE TRIGGER books_updated_at_fill BEFORE UPDATE ON books FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

-- book_history
ALTER TABLE book_history
    ADD COLUMN created_by INTEGER NOT NULL DEFAULT '1',
    ADD COLUMN updated_by INTEGER NULL,
    ADD COLUMN updated_at TIMESTAMP NULL;

ALTER TABLE book_history
    ALTER COLUMN created_by DROP DEFAULT,
    ALTER COLUMN created_at SET DEFAULT CURRENT_TIMESTAMP;

-- Trigger updated_at for book_history
CREATE TRIGGER book_history_updated_at_fill BEFORE UPDATE ON book_history FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

-- paper_book
ALTER TABLE paper_book
    ADD COLUMN created_by INTEGER NOT NULL DEFAULT '1',
    ADD COLUMN updated_by INTEGER NULL,
    ADD COLUMN created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ADD COLUMN updated_at TIMESTAMP NULL,
    ADD COLUMN last_hist_id INTEGER NULL;

ALTER TABLE paper_book
    ALTER COLUMN created_by DROP DEFAULT;

ALTER TABLE paper_book
    DROP COLUMN total_amount,
    DROP COLUMN free_amount;

-- Trigger updated_at for paper_book
CREATE TRIGGER paper_book_updated_at_fill BEFORE UPDATE ON paper_book FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

-- e_book
ALTER TABLE e_book
    ADD COLUMN created_by INTEGER NOT NULL DEFAULT '1',
    ADD COLUMN updated_by INTEGER NULL,
    ADD COLUMN created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ADD COLUMN updated_at TIMESTAMP NULL;

ALTER TABLE e_book
    ALTER COLUMN created_by DROP DEFAULT;

-- Trigger updated_at for e_book
CREATE TRIGGER e_book_updated_at_fill BEFORE UPDATE ON e_book FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

-- plan
ALTER TABLE plan
    ADD COLUMN created_by INTEGER NOT NULL DEFAULT '1',
    ADD COLUMN updated_by INTEGER NULL,
    ADD COLUMN created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ADD COLUMN updated_at TIMESTAMP NULL;

ALTER TABLE plan
    ALTER COLUMN created_by DROP DEFAULT;

-- Trigger updated_at for plan
CREATE TRIGGER plan_updated_at_fill BEFORE UPDATE ON plan FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

-- progress
ALTER TABLE progress
    ADD COLUMN created_by INTEGER NOT NULL DEFAULT '1',
    ADD COLUMN updated_by INTEGER NULL,
    ADD COLUMN updated_at TIMESTAMP NULL;

ALTER TABLE progress
    ALTER COLUMN created_by DROP DEFAULT,
    ALTER COLUMN created_at SET DEFAULT CURRENT_TIMESTAMP;

-- Trigger updated_at for progress
CREATE TRIGGER progress_updated_at_fill BEFORE UPDATE ON progress FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

-- review
ALTER TABLE review
    ADD COLUMN created_by INTEGER NOT NULL DEFAULT '1',
    ADD COLUMN updated_by INTEGER NULL;

ALTER TABLE review
    ALTER COLUMN created_by DROP DEFAULT,
    ALTER COLUMN created_at SET DEFAULT CURRENT_TIMESTAMP;

-- Trigger updated_at for review
CREATE TRIGGER review_updated_at_fill BEFORE UPDATE ON review FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

-- wait_list
ALTER TABLE wait_list
    ADD COLUMN created_by INTEGER NOT NULL DEFAULT '1',
    ADD COLUMN updated_by INTEGER NULL,
    ADD COLUMN updated_at TIMESTAMP NULL;

ALTER TABLE wait_list
    ALTER COLUMN created_by DROP DEFAULT,
    ALTER COLUMN created_at SET DEFAULT CURRENT_TIMESTAMP;

-- Trigger updated_at for wait_list
CREATE TRIGGER wait_list_updated_at_fill BEFORE UPDATE ON wait_list FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

-- roles
ALTER TABLE roles
    ADD COLUMN created_by INTEGER NOT NULL DEFAULT '1',
    ADD COLUMN created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ADD COLUMN updated_by INTEGER NULL,
    ADD COLUMN updated_at TIMESTAMP NULL;

ALTER TABLE roles
    ALTER COLUMN created_by DROP DEFAULT;

-- Trigger updated_at for roles
CREATE TRIGGER roles_updated_at_fill BEFORE UPDATE ON roles FOR EACH ROW EXECUTE PROCEDURE update_modified_column();

-- Add GUEST role
INSERT INTO roles (role_id, name, created_by)
VALUES (3, 'GUEST', 1);