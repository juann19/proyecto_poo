
package modell;

import java.util.Date;

public class recordatorio {

private int recordatorio_id;
private Date fecha_hora;
private int tarea_id;

public recordatorio(){
    
}

    public recordatorio(int recordatorio_id, Date fecha_hora, int tarea_id) {
        this.recordatorio_id = recordatorio_id;
        this.fecha_hora = fecha_hora;
        this.tarea_id = tarea_id;
    }

    public int getRecordatorio_id() {
        return recordatorio_id;
    }

    public void setRecordatorio_id(int recordatorio_id) {
        this.recordatorio_id = recordatorio_id;
    }

    public Date getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(Date fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public int getTarea_id() {
        return tarea_id;
    }

    public void setTarea_id(int tarea_id) {
        this.tarea_id = tarea_id;
    }


    
}
