/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

public class User {
        private int userId;
        private String email;
        private String password;
        private int roleId;
        private int statusId;

        public User() {
        }

        public User(int userId, String email, String password, int roleId, int statusId) {
                this.userId = userId;
                this.email = email;
                this.password = password;
                this.roleId = roleId;
                this.statusId = statusId;
        }

        public int getUserId() {
                return userId;
        }

        public void setUserId(int userId) {
                this.userId = userId;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public int getRoleId() {
                return roleId;
        }

        public void setRoleId(int roleId) {
                this.roleId = roleId;
        }

        public int getStatusId() {
                return statusId;
        }

        public void setStatusId(int statusId) {
                this.statusId = statusId;
        }

}
