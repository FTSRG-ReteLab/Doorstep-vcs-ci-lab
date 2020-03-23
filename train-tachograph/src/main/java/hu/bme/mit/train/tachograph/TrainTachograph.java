package hu.bme.mit.train.tachograph;
import hu.bme.mit.train.*;
import com.google.common.collect.Table;
import java.time.LocalDateTime;

public class TrainTachograph {
    Table<Integer, LocalDateTime, Integer> tachographTable = HashBasedTable.create(); 

    private seedTable() {
        TrainController trainController = new TrainControllerImpl();
        TrainUser trainUser = new TrainUserImpl();

        int joystickPos = trainUser.getJoystickPosition();
        LocalDateTime currentTime = LocalDateTime.now();
        int referenceSpeed = trainSystem.getReferenceSpeed();

        tachographTable.put(joystickPos, currentTime, referenceSpeed); 
    }

    private Table getTable() {
        return tachographTable;
    }
}