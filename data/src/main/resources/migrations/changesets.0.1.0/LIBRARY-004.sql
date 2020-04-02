DROP TABLE IF EXISTS e_book;
CREATE TABLE e_book(
    e_book_id    SERIAL PRIMARY KEY,
    books_id     INTEGER NOT NULL,
    type         VARCHAR(20) NOT NULL,
    edition      VARCHAR(50) NULL,
    format       VARCHAR(20) NOT NULL,
    publish_year CHAR(4) NULL,
    publisher    VARCHAR(50) NULL,
    file         BYTEA NULL,
    file_type    VARCHAR(6) NOT NULL,
    CONSTRAINT books_fk FOREIGN KEY (books_id) REFERENCES books (books_id)
        ON UPDATE CASCADE
        ON DELETE CASCADE

);