package ruslan.simple_task_tracker.persistence.entities.authorization;

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
