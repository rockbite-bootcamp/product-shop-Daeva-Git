package com.rockbite.bootcamp.pool;

import java.util.ArrayList;

public abstract class Pool<T extends Poolable>{

    ArrayList<T> freeObjects = new ArrayList<T>();

    ArrayList<T> usedObjects = new ArrayList<T>();

    public static int INITIAL_CAPACITY = 100;

    public Pool () {
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            T object = obtain();
            free(object);
        }
    }

    protected abstract T newObject();

    public T obtain () {
        if (freeObjects.isEmpty()) {
            T object = newObject();
            freeObjects.add(object);
        }

        T object = freeObjects.remove(0);
        usedObjects.add(object);

        return object;
    }

    public void free (T object) {
        usedObjects.remove(object);
        freeObjects.add(object);

        object.reset();
    }
}
