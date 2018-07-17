package com.arm.mbed.cloud.sdk.common;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFileDownload {

    @Test
    public void testGetFileExtension() {

        String filePath = "201806-0157528bb84102420a01321400000000-activedevices.098052628912094123.gz";
        assertEquals("gz", FileDownload.getFileExtension(filePath));
        filePath = "C:\\Users\\adrcab01\\AppData\\Local\\Temp\\201806-0157528bb84102420a01321400000000-activedevices.5098052628912094123.7z";
        assertEquals("7z", FileDownload.getFileExtension(filePath));
        filePath = "https://s3.eu-west-1.amazonaws.com/billing-final-reports-9eb5/201806/7df13c0e372d4346a8aeeb1167d75116/201806-0157528bb84102420a01321400000000-firmwareupdates.csv.gz";
        assertEquals("csv.gz", FileDownload.getFileExtension(filePath));
        filePath = "201806-0157528bb84102420a01321400000000-activedevices.098052628912094123.";
        assertEquals("", FileDownload.getFileExtension(filePath));
        filePath = "C:\\Users\\adrcab01\\AppData\\Local\\Temp\\201806-0157528bb84102420a01321400000000-activedevices.5098052628912094123.7z ";
        assertEquals("7z", FileDownload.getFileExtension(filePath));

    }

    @Test
    public void testGetFileNameWithoutExtension() {
        String filePath = "201806-0157528bb84102420a01321400000000-activedevices.098052628912094123.gz";
        assertEquals("201806-0157528bb84102420a01321400000000-activedevices.098052628912094123",
                     FileDownload.getFileNameWithoutExtension(filePath));
        filePath = "201806-0157528bb84102420a01321400000000-activedevices.5098052628912094123.7z";
        assertEquals("201806-0157528bb84102420a01321400000000-activedevices.5098052628912094123",
                     FileDownload.getFileNameWithoutExtension(filePath));
        filePath = "201806-0157528bb84102420a01321400000000-firmwareupdates.csv.gz";
        assertEquals("201806-0157528bb84102420a01321400000000-firmwareupdates",
                     FileDownload.getFileNameWithoutExtension(filePath));
        filePath = "201806-0157528bb84102420a01321400000000-firmwareupdates .csv.gz ";
        assertEquals("201806-0157528bb84102420a01321400000000-firmwareupdates ",
                     FileDownload.getFileNameWithoutExtension(filePath));
    }

}
