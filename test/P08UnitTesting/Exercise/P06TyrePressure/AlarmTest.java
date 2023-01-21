package P08UnitTesting.Exercise.P06TyrePressure;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.AbstractSequentialList;

import static org.junit.Assert.*;

public class AlarmTest {

    @Test
    public void testIfAlarmIsOffWithValidInput(){
        Sensor mockedSensor = Mockito.mock(Sensor.class);
        Alarm alarm = new Alarm(mockedSensor);
        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(19.3);

        alarm.check();
        Assert.assertFalse(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmOsOnWithLowPressure(){
        Sensor mockedSensor = Mockito.mock(Sensor.class);
        Mockito.when(mockedSensor.popNextPressurePsiValue()).thenReturn(1.0);
        Alarm alarm = new Alarm(mockedSensor);

        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmIsOnWithToHighPressure(){
        Sensor mock = Mockito.mock(Sensor.class);
        Mockito.when(mock.popNextPressurePsiValue()).thenReturn(22.0);
        Alarm alarm = new Alarm(mock);

        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }


}