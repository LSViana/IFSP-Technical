package System.Data;

import System.Business.EntityModel;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntityData<T extends EntityModel> {

    private Class _class;
    private T _dummy;
    private static StringBuilder _builder;

    static {
        _builder = new StringBuilder();
    }

    public EntityData(Class _class) throws Exception {
        this._class = _class;
        _dummy = activator();
    }

    private T activator() throws Exception {
        java.lang.reflect.Parameter[] _params = _class.getConstructors()[0].getParameters();
        ArrayList<Object> parameters = new ArrayList<>();
        for (java.lang.reflect.Parameter p : _params) {
            if (p.getType().isInstance(0)) {
                parameters.add(0);
            } else if (p.getType().isInstance(false)) {
                parameters.add(false);
            } else {
                parameters.add(null);
            }
        }
        T _activated = (T) _class.getConstructors()[0].newInstance(parameters.toArray());
        return _activated;
    }

    public List<T> getAll() throws Exception {
        List<T> _results = new ArrayList<>();
       _builder.setLength(0);
        _builder
                .append("SELECT * FROM ")
                .append(_class.getSimpleName());
        java.lang.reflect.Field[] _fields = _dummy.getClass().getDeclaredFields();
        java.sql.Connection _conn = Connection.openConnection();
        PreparedStatement _stmt = _conn.prepareStatement(_builder.toString());
        ResultSet _rs = _stmt.executeQuery();
        while (_rs.next()) {
            T _result = activator();
            for (int i = 0; i < _fields.length; i++) {
                java.lang.reflect.Field f = _fields[i];
                java.lang.reflect.Method m = _class.getMethod("set" + f.getName(), f.getType());
                if (f.getType().isInstance(0)) {
                    m.invoke(_result, _rs.getInt(i + 1));
                } else if (f.getType().isInstance(false)) {
                    m.invoke(_result, _rs.getBoolean(i + 1));
                } else {
                    m.invoke(_result, _rs.getObject(i + 1));
                }
            }
            _results.add(_result);
        }
        return _results == null ? null : _results;
    }

    public T get(Integer index) throws Exception {
        _builder.setLength(0);
        _builder
                .append("SELECT * FROM ")
                .append(_class.getSimpleName())
                .append(" LIMIT ")
                .append(index)
                .append(", 1");
        java.lang.reflect.Field[] _fields = _dummy.getClass().getDeclaredFields();
        java.sql.Connection _conn = Connection.openConnection();
        PreparedStatement _stmt = _conn.prepareStatement(_builder.toString());
        ResultSet _rs = _stmt.executeQuery();
        T _result = activator();
        while (_rs.next()) {
            for (int i = 0; i < _fields.length; i++) {
                java.lang.reflect.Field f = _fields[i];
                java.lang.reflect.Method m = _class.getMethod("set" + f.getName(), f.getType());
                if (f.getType().isInstance(0)) {
                    m.invoke(_result, _rs.getInt(i + 1));
                } else if (f.getType().isInstance(false)) {
                    m.invoke(_result, _rs.getBoolean(i + 1));
                } else {
                    m.invoke(_result, _rs.getObject(i + 1));
                }
            }
        }
        return _result == null ? null : _result;
    }

    public T get(String key) throws Exception {
        String[] _keys = key.split(",");
        _builder.setLength(0);
        _builder.append("SELECT * FROM ").append(_class.getSimpleName()).append(" WHERE ");
        Integer[] ids = _dummy.getIds();
        java.lang.reflect.Field[] _fields = _dummy.getClass().getDeclaredFields();
        for (int i = 0; i < _fields.length; i++) {
            java.lang.reflect.Field f = _fields[i];
            if (f.getName().toLowerCase().contains("id")) {
                _builder.append(f.getName()).append("=").append(_keys[i]).append(" OR ");
            }
        }
        _builder.delete(_builder.length() - 4, _builder.length());
        _builder.append(" LIMIT 1;");
        java.sql.Connection _conn = Connection.openConnection();
        PreparedStatement _stmt = _conn.prepareStatement(_builder.toString());
        ResultSet _rs = _stmt.executeQuery();
        T _result = activator();
        while (_rs.next()) {
            for (int i = 0; i < _fields.length; i++) {
                java.lang.reflect.Field f = _fields[i];
                java.lang.reflect.Method m = _class.getMethod("set" + f.getName(), f.getType());
                if (f.getType().isInstance(0)) {
                    m.invoke(_result, _rs.getInt(i + 1));
                } else if (f.getType().isInstance(false)) {
                    m.invoke(_result, _rs.getBoolean(i + 1));
                } else {
                    m.invoke(_result, _rs.getObject(i + 1));
                }
            }
        }
        return _result == null ? null : _result;
    }

    public List filter(String filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public T insert(T item) throws
            ClassNotFoundException,
            SQLException,
            IllegalAccessException,
            InvocationTargetException,
            NoSuchMethodException {
        _builder.setLength(0);
        _class = item.getClass();
        java.lang.reflect.Field[] _fields = _class.getDeclaredFields();
        _builder.append("INSERT INTO ").append(item.getClass().getSimpleName()).append("(");
        for (java.lang.reflect.Field f : _fields) {
            _builder.append(f.getName()).append(", ");
        }
        _builder.deleteCharAt(_builder.length() - 2);
        _builder.deleteCharAt(_builder.length() - 1);
        _builder.append(") VALUES(");
        for (java.lang.reflect.Field f : _fields) {
            _builder.append("?, ");
        }
        _builder.deleteCharAt(_builder.length() - 2);
        _builder.deleteCharAt(_builder.length() - 1);
        _builder.append(");");
        java.sql.Connection _conn = Connection.openConnection();
        PreparedStatement _stmt = _conn.prepareStatement(_builder.toString());
        for (Integer i = 1; i <= _fields.length; i++) {
            String value = _class.getDeclaredMethod("get" + _fields[i - 1].getName()).invoke(item, null).toString();
            _stmt.setString(i, value);
        }
        _stmt.executeUpdate();
        Connection.closeConnetion(_conn);
        return item;
    }

    public boolean insertRange(List<T> items) {
        try {
            for (T item : items) {
                insert(item);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean exists(String key) throws ClassNotFoundException, SQLException {
        String[] _keys = key.split(",");
        _builder.setLength(0);
        _builder.append("SELECT COUNT(*) FROM ").append(_class.getSimpleName()).append(" WHERE ");
        Integer[] ids = _dummy.getIds();
        java.lang.reflect.Field[] _fields = _dummy.getClass().getDeclaredFields();
        for (int i = 0; i < _fields.length; i++) {
            java.lang.reflect.Field f = _fields[i];
            if (f.getName().toLowerCase().contains("id")) {
                _builder.append(f.getName()).append("=").append(_keys[i]).append(" OR ");
            }
        }
        _builder.delete(_builder.length() - 4, _builder.length());
        _builder.append(";");
        java.sql.Connection _conn = Connection.openConnection();
        PreparedStatement _stmt = _conn.prepareStatement(_builder.toString());
        ResultSet _rs = _stmt.executeQuery();
        _rs.next();
        if (_rs.getInt(1) > 0) {
            return true;
        }
        return false;
    }
}
