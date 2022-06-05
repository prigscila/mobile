package com.ifsc.tacoapp.controller;

import android.content.Context;
import com.ifsc.tacoapp.model.Taco;
import com.ifsc.tacoapp.model.TacoDao;
import java.util.ArrayList;

public class TacoController {
    private Context context;
    private static TacoDao TacosDao;

    public TacoController(Context context) {
        this.context =context;

        if (TacosDao == null) {
            TacosDao = new TacoDao(context);
        }
    }

    public ArrayList<Taco> listTacos() {
        return TacosDao.getTacos();
    }

    public Taco getTaco(Integer id){
        return TacosDao.getTacoById(id);
    }
}

