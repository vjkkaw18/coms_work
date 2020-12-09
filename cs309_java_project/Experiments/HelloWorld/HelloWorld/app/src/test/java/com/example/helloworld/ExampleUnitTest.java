package com.example.helloworld;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest extends AppCompatActivity {
    JSONArray array2;
    String store2;
    boolean responded = false;

    @Mock
    private Context context;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testingMock() {
        TestClassForMock mockObject = mock(TestClassForMock.class);
        when(mockObject.add(10,20)).thenReturn(30);
        assertEquals(30, mockObject.add(10, 20));
    }

    @Test
    public void testingOne() {
        MyAppApplication mock2 = new MyAppApplication();
        mock2.setHospitalName("Mary Greeley Medical Center");
        assertEquals("Mary Greeley Medical Center", mock2.getHospitalName());
        State_Iowa mockObject = new State_Iowa();
        //mockObject.initialize("Testing");

        //mockObject.addItemsOnSpinnerIowa();
        //mockObject.jsonParse();
    }

    @Test
    public void testingTwo() {
        MyAppApplication mock2 = new MyAppApplication();
        mock2.setStateSelect("Iowa");
    }

  //  @Mock
   // MyAppApplication app2 = (MyAppApplication) MockitoJUnit.rule();

 //   @Mock
  //  UserInventory mock3 = (UserInventory) MockitoJUnit.rule();


    @Test
    public void testingThree() {
      UserInventory mock3 = mock(UserInventory.class);
        int mockhospital = 1;
        mock3.getData(3);

        MainActivity mock4 = mock(MainActivity.class);
        String test1 = "djkingiastate.edu";
        assertEquals(false, mock4.isEmailString(test1));

//        EditText edittext = new EditText(context);
//        edittext.setText("  ");
 //       when(mock4.isEmpty(edittext)).thenReturn(true);
       // UserInventory mock3 = new UserInventory();
    }

    @Test
    public void testingFour() {
        String testString = "hello";
        TestClassForMock mock4 = mock(TestClassForMock.class);
        when(mock4.isEmail("djking")).thenReturn(false);
        Boolean b = mock4.isEmail("djking");
        assertEquals(false, b);
    }

    @Test
    public void testingFive() {
        String l = "hello@gmail.com";
        String p = "password";
        TestClassForMock mock5 = mock(TestClassForMock.class);
        when(mock5.loginSuccessfulMock(l, p)).thenReturn(false);
        Boolean b = mock5.loginSuccessfulMock(l, p);
        assertEquals(false, b);

        l = "test@gmail.com";
        p = "password12345";
        when(mock5.loginSuccessfulMock(l, p)).thenReturn(true);
        Boolean bb = mock5.loginSuccessfulMock(l, p);
        assertEquals(true, bb);
    }

    @Test
    public void testingSix() {
        TestClassForMock mock6 = mock(TestClassForMock.class);
        Boolean b = mock6.addItemsOnSpinner();
        assertEquals(false, b);
        }

    @Test
    public void testingSeven() {
        HospitalList mock7 = mock(HospitalList.class);
        HospitalWebpageActivity mock = mock(HospitalWebpageActivity.class);
    }

    @Test
    public void testingEight() {
        //testing manager login
        //mock for manager logins
        String l = "manager";
        String p = "password";
        TestClassForMock mock5 = mock(TestClassForMock.class);
        when(mock5.loginSuccessfulMock(l, p)).thenReturn(false);
        Boolean b = mock5.loginSuccessfulMock(l, p);
        assertEquals(false, b);

        l = "managers@admin.com";
        p = "password";
        when(mock5.loginSuccessfulMock(l, p)).thenReturn(true);
        Boolean bb = mock5.loginSuccessfulMock(l, p);
        assertEquals(true, bb);
    }

}