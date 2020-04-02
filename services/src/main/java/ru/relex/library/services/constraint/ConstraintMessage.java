package ru.relex.library.services.constraint;

public final class ConstraintMessage {

    private ConstraintMessage() {
    }

    public static class Field {

        private Field() {
        }


        public static final String USERNAME = "USERNAME";
        public static final String PASSWORD = "PASSWORD";
        public static final String FIRST_NAME = "FIRSTNAME";
        public static final String LAST_NAME = "LASTNAME";
        public static final String ROLE = "ROLE";
        public static final String MIDDLE_NAME = "MIDDLENAME";
        public static final String PERSONAL_INFO = "PERSONALINFO";
        public static final String NAME = "NAME";
        public static final String AUTHOR = "AUTHOR";
        public static final String BOOKS_ID = "BOOKSID";
        public static final String EDITION = "EDITION";
        public static final String FORMAT = "FORMAT";
        public static final String PUBLISHYEAR = "PUBLISHYEAR";
        public static final String PUBLISHER = "PUBLISHER";
        public static final String TOTALAMOUNT = "TOTALAMOUNT";
        public static final String FREEAMOUNT = "FREEAMOUNT";
        public static final String USER_ID = "USERID";
        public static final String RANK = "RANK";
        public static final String REVIEW = "REVIEW";
		public static final String STATUS = "STATUS";
        public static final String PAPER_BOOK_ID = "PAPERBOOKID";
		public static final String TYPE = "TYPE";
		public static final String FILE = "FILE";
		public static final String FILETYPE = "FILETYPE";
        public static final String PAGEGOT = "PAGEGOT";    }

    public static class Constraint {
        private Constraint() {
        }

        public static final String IS_NULL = "_NULL";
        public static final String IS_EMPTY = "_EMPTY";
        public static final String TOO_LONG = "_TOOLONG";
        public static final String TOO_SHORT = "_TOOSHORT";
        public static final String NOT_POSITIVE = "_NOTPOSITIVE";
        public static final String NOT_FINDED = "_NOTFINDED";
    }
}
