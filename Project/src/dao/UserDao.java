package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.User;

public class UserDao {

	public User findByLoginId(String loginId,String password) {
        Connection conn = null;

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE login_id = ? AND password = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,loginId);
            pStmt.setString(2,password);
            ResultSet rs = pStmt.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
            if (!rs.next()) {
            	return null;

            }else {
            	int idData = rs.getInt("id");
                String loginIdData = rs.getString("login_id");
                String name = rs.getString("name");
                String birth_date = rs.getString("birth_date");
                String create_date = rs.getString("create_date");
                String update_date = rs.getString("update_date");
                User user = new User(idData, loginIdData, name, birth_date, create_date, update_date);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

	public User findById(String id) {
        Connection conn = null;

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user WHERE id = ?";

             // SELECTを実行し、結果表を取得
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1,id);
            ResultSet rs = pStmt.executeQuery();

            // 結果表に格納されたレコードの内容を
            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
            if (!rs.next()) {
            	return null;

            }else {
            	int idData = rs.getInt("id");
                String loginIdData = rs.getString("login_id");
                String name = rs.getString("name");
                String birth_date = rs.getString("birth_date");
                String create_date = rs.getString("create_date");
                String update_date = rs.getString("update_date");
                User user = new User(idData, loginIdData, name, birth_date, create_date, update_date);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
    }

	public List<User> findAll() {
        Connection conn = null;
        List<User> userList = new ArrayList<User>();

        try {
            // データベースへ接続
            conn = DBManager.getConnection();

            // SELECT文を準備
            String sql = "SELECT * FROM user";

             // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果表に格納されたレコードの内容を
            // Employeeインスタンスに設定し、ArrayListインスタンスに追加
            while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String name = rs.getString("name");
                String birthDate = rs.getString("birth_date");
                User user = new User(id, loginId, name, birthDate);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            // データベース切断
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return userList;
    }

	public boolean createUser(String loginId,String password,String passwordCheck,String name,String birthDate) {

		Connection conn = null;
		if(password.equals(passwordCheck)) {
			try {
				conn = DBManager.getConnection();
				String sql = "INSERT INTO user(login_id,name,birth_date,password,create_date,update_date) VALUES(?,?,?,?,?,?)";
				Date d = new Date();
				String createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);

				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, loginId);
				pStmt.setString(2, name);
				pStmt.setString(3, birthDate);
				pStmt.setString(4, password);
				pStmt.setString(5, createDate);
				pStmt.setString(6, createDate);

				int result = pStmt.executeUpdate();
				System.out.println(result + "行が追加されました。");

				return true;

			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				if(conn != null) {
					try {
						conn.close();
					}catch(SQLException e) {
						e.printStackTrace();
						return false;
					}
				}
			}
		}else {
			return false;
		}

	}

	public boolean userUpdate(String id,String password,String pCheck,String name,String birth_date) {
		Connection conn = null;
		if(password.equals(pCheck)) {
			try {
				conn = DBManager.getConnection();
				String sql = "UPDATE user SET password = ?, name = ?, birth_date = ?,update_date = ? WHERE id = ?";
				Date d = new Date();
				String updateDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);

				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, password);
				pStmt.setString(2, name);
				pStmt.setString(3, birth_date);
				pStmt.setString(4, updateDate);
				pStmt.setInt(5, Integer.parseInt(id));

				int result = pStmt.executeUpdate();
				System.out.println(result + "行が追加されました。");

				return true;

			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}finally {
				if(conn != null) {
					try {
						conn.close();
					}catch(SQLException e){
						e.printStackTrace();
						return false;
					}
				}
			}
		}else {
			return false;
		}
	}

	public boolean userUpdateNmBd(String id, String name, String birth_date) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();

			String sql = "UPDATE user SET name = ?, birth_date = ?,update_date = ? WHERE id = ?";
			Date d = new Date();
			String updateDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, birth_date);
			pStmt.setString(3, updateDate);
			pStmt.setInt(4, Integer.parseInt(id));

			int result = pStmt.executeUpdate();
			System.out.println(result + "行が追加されました。");

			return true;

		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e){
					e.printStackTrace();
					return false;
				}
			}
		}
	}

	public List<User> retrieveUsers(String login_id, String name, String birth_date){
		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {

			conn = DBManager.getConnection();

			StringBuilder sql = new StringBuilder("SELECT * FROM user WHERE login_id = ?, name = ?, birt_date = ?");
				if(login_id != "") {
					sql.append("login_id =");
					sql.append(login_id);
				}
				if(name != ""){
					sql.append("name =");
					sql.append(name);
				}
				if(birth_date != "") {
					sql.append("birth_date =");
					sql.append(birth_date);
				}


			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login_id);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
                int id = rs.getInt("id");
                String loginId = rs.getString("login_id");
                String usNm = rs.getString("name");
                String birthDate = rs.getString("birth_date");
                User user = new User(id, loginId, usNm, birthDate);
                userList.add(user);
            }


		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(conn != null) {
				try {
				conn.close();
				}catch(SQLException e) {
				e.printStackTrace();
				return null;
				}
			}
		}
		return userList;
	}

}
