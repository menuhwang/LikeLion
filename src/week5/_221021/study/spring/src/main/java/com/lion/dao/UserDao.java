package com.lion.dao;

import com.lion.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws SQLException {
        StatementStrategy st = new AddStatement(user);
        jdbcContextWithStatementStrategy(st);
    }

    public User findById(String id) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            c = connectionMaker.makeConnection();
            ps = c.prepareStatement("SELECT users.id, users.name, users.password FROM users WHERE users.id = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignore) {
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ignore) {
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException ignore) {
                }
            }
        }
        return user;
    }

    public int getCountAll() throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            c = connectionMaker.makeConnection();
            ps = c.prepareStatement("SELECT COUNT(*) FROM users");
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignore) {
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ignore) {
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException ignore) {
                }
            }
        }
        return count;
    }

    public void deleteAll() throws SQLException{
        StatementStrategy st = new DeleteAllStatement();
        jdbcContextWithStatementStrategy(st);
    }

    private void jdbcContextWithStatementStrategy(StatementStrategy stmt) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = connectionMaker.makeConnection();
            ps = stmt.makePreparedStatement(c);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ignore) {
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException ignore) {
                }
            }
        }
    }
}
