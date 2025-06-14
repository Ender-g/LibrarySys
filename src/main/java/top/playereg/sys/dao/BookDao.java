/*
 *
 * @author: playereg
 * @description: 书本数据访问层
 * @version: 1.0
 *
 * */

package top.playereg.sys.dao;

import top.playereg.sys.entity.Books;
import top.playereg.sys.utils.DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    // 添加图书
    public static boolean addBook(Books book) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        try {

            ps = conn.prepareStatement("INSERT INTO tb_books (bookName, bookNumber, is_del) VALUES (?, ?, 0)");
            ps.setString(1, book.getBookName());
            ps.setInt(2, book.getBookNumber());
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 删除图书
    public boolean deleteBook(int id) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tb_books SET is_del = 1 WHERE id = ? AND is_del = 0");
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 更新图书信息
    public static boolean updateBook(Books book) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        try {
            // 只更新未删除的书籍
            ps = conn.prepareStatement("UPDATE tb_books SET bookName = ?, bookNumber = ? WHERE id = ? AND is_del = 0");
            ps.setString(1, book.getBookName());
            ps.setInt(2, book.getBookNumber());
            ps.setInt(3, book.getId());

            int rows = ps.executeUpdate();
            return rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 获取所有未删除图书
    public static List<Books> getAllBooks() {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Books> booksList = new ArrayList<>();
        try {
            ps = conn.prepareStatement("SELECT * FROM tb_books WHERE is_del = 0");
            rs = ps.executeQuery();
            while (rs.next()) {
                Books book = new Books();
                book.setId(rs.getInt("id"));
                book.setBookName(rs.getString("bookName"));
                book.setBookNumber(rs.getInt("bookNumber"));
                book.setIs_del(rs.getString("is_del"));
                booksList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return booksList;
    }

    // 获取所有已删除图书
    public static List<Books> getDeletedBooks() {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Books> booksList = new ArrayList<>();
        try {
            ps = conn.prepareStatement("SELECT * FROM tb_books WHERE is_del = 1");
            rs = ps.executeQuery();
            while (rs.next()) {
                Books book = new Books();
                book.setId(rs.getInt("id"));
                book.setBookName(rs.getString("bookName"));
                book.setBookNumber(rs.getInt("bookNumber"));
                book.setIs_del(rs.getString("is_del"));
                booksList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return booksList;
    }

    // 获取书本总种数
    public static int countBooks() {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            ps = conn.prepareStatement("SELECT COUNT(*) FROM tb_books WHERE is_del = 0");
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    // 获取指定id的图书的信息
    public static Books getBook(int id) {
        Connection conn = DbUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Books book = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM tb_books WHERE id = ? AND is_del = 0");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                book = new Books();
                book.setId(rs.getInt("id"));
                book.setBookName(rs.getString("bookName"));
                book.setBookNumber(rs.getInt("bookNumber"));
                book.setIs_del(rs.getString("is_del"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return book;
    }

}