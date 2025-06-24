/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.YearMonth;
import java.util.ArrayList;
import model.guests;
import model.reports;
import model.rooms;
import utils.acceptable;
import utils.inputter;

/**
 *
 * @author jso
 */
public class report_controller extends ArrayList<reports> {

    public void monthlyRevenueReport(reservation_controller reservationList, room_controller roomList) {
        YearMonth targetMonth = inputter.getYearMonth(
                "Input target month for revenue report: ",
                "Wrong input format (Must be MM/yyyy)",
                acceptable.MONTH_REVENUE_FORMAT,
                false
        );

        boolean hasReport = false;

        for (guests guest : reservationList) {
            if (YearMonth.from(guest.getStartDate()).equals(targetMonth)) {
                rooms room = roomList.searchRecById(guest.getDesiredRoomId());
                if (room != null) {
                    double amount = room.getDailyRate() * guest.getNumOfRentalDays();

                    reports report = new reports(
                            inputter.generateCode(),
                            room.getRoomId(),
                            room.getRoomName(),
                            room.getRoomType(),
                            room.getDailyRate(),
                            amount
                    );

                    this.add(report);
                    hasReport = true;
                }
            }
        }

        if (!hasReport) {
            System.out.println("\nMonthly Revenue Report-" + targetMonth);
            System.out.println("---------------------------------------------------------------");
            System.out.println("RoomID  | Room Name        | Type     | DailyRate  |     Amount");
            System.out.println("---------------------------------------------------------------");
            System.out.println("There is no data on guests who have rented rooms");
            System.out.println("---------------------------------------------------------------");
        } else {
            System.out.println("\nMonthly Revenue Report-" + targetMonth);
            System.out.println("---------------------------------------------------------------");
            System.out.println("RoomID  | Room Name        | Type     | DailyRate  |     Amount");
            System.out.println("---------------------------------------------------------------");
            for (reports report : this) {
                System.out.print(report.displayFull());
            }
            System.out.println("---------------------------------------------------------------");
        }
    }

    public void revenueReportByRoomType(reservation_controller reservationList, room_controller roomList) {
        String roomType = inputter.getString(
                "Input room type for report: ",
                "Input must be a String",
                acceptable.ROOM_TYPE,
                false
        );
        
        for (rooms room : roomList) {
            if (room.getRoomType().equals(roomType)) {
                System.out.println(room.display());
                
            }
        }
    }
}
