package com.ederson.oliveira.trabalhoandroid.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ederson.oliveira.trabalhoandroid.R;

import java.util.List;

import retrofit2.Callback;

/**
 * Created by aluno on 16/04/18.
 */

public class AdapterCourse extends BaseAdapter{

    Context contexto;
    List<Course> cursos;

    public AdapterCourse(Context contexto,
                         List<Course> cursos) {
        this.contexto = contexto;
        this.cursos = cursos;
    }
    @Override
    public int getCount() {return cursos.size(); }

    @Override
    public Object getItem(int position) {
        return cursos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewLinha =
                LayoutInflater.from(contexto).
                        inflate(R.layout.linha_lista_curso,parent,
                                false);

        TextView curso = (TextView) viewLinha.findViewById(R.id.textViewtitulo);
        TextView subtitulo = (TextView) viewLinha.findViewById(R.id.textViewsubtitulo);

        Course course = cursos.get(position);
        curso.setText(course.getTitle());
        subtitulo.setText(course.getSubtitle());

        return viewLinha;
    }
}
