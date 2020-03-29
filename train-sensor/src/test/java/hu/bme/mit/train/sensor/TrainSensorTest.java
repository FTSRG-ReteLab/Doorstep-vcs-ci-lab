package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController mockTrainController;
    TrainUser mockTrainUser;
    TrainSensorImpl trainSensor;

    @Before
    public void before() {
        mockTrainController = mock(TrainController.class);
        mockTrainUser = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockTrainController, mockTrainUser);
    }

    @Test
    public void ThisIsAnExampleTestStub() {
        
    }

    @Test
    public void AbsoluteMarginMin() {
        trainSensor.overrideSpeedLimit(-1);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }
    @Test
    public void AbsoluteMarginMax() {
        trainSensor.overrideSpeedLimit(501);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void RelativeMargin() {
        trainSensor.overrideSpeedLimit(2);
        verify(mockTrainUser, times(1)).setAlarmState(true);
    }

    @Test
    public void OkMargin() {
        trainSensor.overrideSpeedLimit(300);
        verify(mockTrainUser, times(0)).setAlarmState(false);
    }
}
