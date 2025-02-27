package ruslan.common.persistence.entities;

public enum Roles {
    ROOT {
        @Override
        public String toString() {
            return "ROLE_root";
        }
    }, ADMIN {
        @Override
        public String toString() {
            return "ROLE_admin";
        }
    }, USER {
        @Override
        public String toString() {
            return "ROLE_user";
        }
    }
}
