package com.example.alfredtaller2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText text_valor1,text_valor2,text_valor3,text_valor4;
    private TextView text_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_valor1= (EditText)findViewById(R.id.EdiTextNum1);
        text_valor2= (EditText)findViewById(R.id.EdiTextNum2);
        text_valor3= (EditText)findViewById(R.id.EdiTextNum3);
        text_valor4= (EditText)findViewById(R.id.EdiTextNum4);

        text_resultado=(TextView)findViewById(R.id.txt_resultado);

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;

    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id= item.getItemId();
        if(id==R.id.ItemAleatorio){
           // Toast.makeText( context: this , text:"aprobado" , Toast.LENGTH_SHORT).show();
        }else if (id==R.id.ItemDistancia){
           // Toast.makeText(context: this, text:"distancia",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


    public boolean ValidarVacio(String n1,String n2,String n3,String n4){

        boolean vacio=false;
        if(n1.isEmpty()){
            text_valor1.setError("Este campo no puede quedar vacio");
            vacio=true;
        }
        if(n2.isEmpty()){
            text_valor2.setError("Este campo no puede quedar vacio");
            vacio=true;
        }
        if(n3.isEmpty()){
            text_valor3.setError("Este campo no puede quedar vacio");
            vacio=true;
        }
        if(n4.isEmpty()){
            text_valor4.setError("Este campo no puede quedar vacio");
            vacio=true;
        }

        return vacio;
    }
    public void PuntoMedio(View view){

        String valor1=text_valor1.getText().toString();
        String valor2=text_valor2.getText().toString();

        String valor3=text_valor3.getText().toString();
        String valor4=text_valor4.getText().toString();

        if(!ValidarVacio(valor1,valor2,valor3,valor4)){
            double num1= Double.parseDouble(valor1);
            double num2= Double.parseDouble(valor2);

            double num3= Double.parseDouble(valor3);
            double num4= Double.parseDouble(valor4);

            double x= (num1+num3)/2;
            double y= (num2+num4)/2;


            String valorx= String.valueOf(x);
            String valory= String.valueOf(y);

            text_resultado.setText("Punto Medio : ( "+valorx+" , "+ valory+" )" );

        }
    }

    public void Pendiente(View view){
        String valor1=text_valor1.getText().toString();
        String valor2=text_valor2.getText().toString();

        String valor3=text_valor3.getText().toString();
        String valor4=text_valor4.getText().toString();

        if(!ValidarVacio(valor1,valor2,valor3,valor4)){
            double num1= Double.parseDouble(valor1);
            double num2= Double.parseDouble(valor2);

            double num3= Double.parseDouble(valor3);
            double num4= Double.parseDouble(valor4);

            double m= (num4-num2)/(num3-num1);

            String pendiente= String.valueOf(m);

            text_resultado.setText("La pendiente es: "+pendiente );

        }

    }
    public String verificarCuadrante(double x, double y ){
        String cuadrante="";
        if(x>0){
            if(y>0){
               cuadrante="I Cuadrante";
            }else if(y<0){
                cuadrante="IV Cuadrante";
            }else{
                cuadrante="esta en el eje de las x";
            }
        }else if(x<0){
            if(y>0){
                cuadrante="II Cuadrante";
            }else if(y<0){
                cuadrante="III Cuadrante";
            }else{
                cuadrante="esta en el eje de las x";
            }
        }else if(x==0){
            if(y==0){
                cuadrante="esta en el origen";
            }else{
                cuadrante="esta en el eje de las y";
            }

        }

        return cuadrante;

    }
    public void Cuadrante(View view){

        String valor1=text_valor1.getText().toString();
        String valor2=text_valor2.getText().toString();

        String valor3=text_valor3.getText().toString();
        String valor4=text_valor4.getText().toString();


        if(!ValidarVacio(valor1,valor2,valor3,valor4)){
            double num1= Double.parseDouble(valor1);
            double num2= Double.parseDouble(valor2);

            double num3= Double.parseDouble(valor3);
            double num4= Double.parseDouble(valor4);

            String punto1=verificarCuadrante(num1,num2);
            String punto2=verificarCuadrante(num3,num4);
            String respuesta = "("+num1+","+num2+"): "+punto1+"\n("+num3+","+num4+"): "+punto2 ;

            text_resultado.setText(respuesta);
        }
    }

}