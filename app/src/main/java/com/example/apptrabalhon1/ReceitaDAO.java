package com.example.apptrabalhon1;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ReceitaDAO {

    public static void inserir(Receita receita, Context context){
        ContentValues valores = new ContentValues();
        valores.put("nome", receita.nome );
        valores.put("tempo", receita.getTempo() );
        valores.put("dificuldade", receita.getDificuldade());
        valores.put("ingredientes", receita.getIngredientes());
        valores.put("modo", receita.getModo());

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.insert("receita", null, valores);
    }

    public static void editar(Receita receita, Context context){
        ContentValues valores = new ContentValues();
        valores.put("nome", receita.nome );
        valores.put("tempo", receita.getTempo() );
        valores.put("dificuldade", receita.getDificuldade());
        valores.put("ingredientes", receita.getIngredientes());
        valores.put("modo", receita.getModo());

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.update("receita", valores, " id = " + receita.id , null );
    }

    public static void excluir(int id, Context context){
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("receita", " id = " + id , null);
    }

    public static List<Receita> getReceitas(Context context){
        List<Receita> lista = new ArrayList<>();
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, nome, tempo, dificuldade, ingredientes, modo FROM receita ORDER BY nome", null );
        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Receita receita = new Receita();
                receita.id = cursor.getInt( 0);
                receita.nome = cursor.getString(1);
                receita.setDificuldade( cursor.getString(2) );
                receita.setIngredientes(cursor.getString(3));
                receita.setModo(cursor.getString(4));
                receita.setTempo(cursor.getInt(5));
                lista.add( receita );
            }while( cursor.moveToNext() );
        }
        return lista;
    }

    public static Receita getReceitaById(Context context, int id){
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, nome, tempo, dificuldade, ingredientes, modo FROM receita WHERE id = " + id, null );
        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            Receita receita = new Receita();
            receita.id = cursor.getInt( 0);
            receita.nome = cursor.getString(1);
            receita.setDificuldade( cursor.getString(2) );
            receita.setIngredientes(cursor.getString(3));
            receita.setModo(cursor.getString(4));
            receita.setTempo(cursor.getInt(5));
            return receita;
        }else{
            return null;
        }
    }



}