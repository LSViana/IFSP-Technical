package System.Data;

import System.Business.EntityModel;
import java.util.ArrayList;
import java.util.List;

public class EntityData<T extends EntityModel> implements DataModel {

    private ArrayList<T> list;

    public EntityData() {
        list = new ArrayList<>();
    }

    @Override
    public List<T> getAll() {
        return list;
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public T get(String key) {
        return list.get(Integer.parseInt(key));
    }

    @Override
    public List filter(String filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(EntityModel item) {
        try {
            list.add((T) item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insertRange(List items) {
        try {
            ArrayList<T> _list = new ArrayList<>();
            for (Object item : items) {
                _list.add((T) item);
            }
            list.addAll(_list);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean exists(String key) {
        for (T current : list) {
            if (current.getIds().length == 1) {
                if (key.equals(current.getIds()[0])) {
                    return true;
                }
            } else if (key.equals(current.getIds())) {
                return true;
            }
        }
        return false;
    }
}
