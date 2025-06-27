/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

        String header = String.format(
                """
                \n
                Revenue Report by Room Type
                ---------------------------
                  Room type   | Amount
                ---------------------------
                """
        );

        String footer = String.format(
                """
                ---------------------------
                """
        );

        String roomType = inputter.getString(
                "Input room type for report: ",
                "Input must be a String",
                acceptable.ROOM_TYPE,
                true
        );

        if (roomType.isEmpty()) {
            Map<String, Double> roomTypeAmounts = new HashMap<>();

            for (guests guest : reservationList) {
                for (rooms room : roomList) {
                    String currentRoomType = room.getRoomType();
                    if (room.getRoomId().equals(guest.getDesiredRoomId())) {
                        double eachRoomAmount = room.getDailyRate() * guest.getNumOfRentalDays();
                        roomTypeAmounts.put(currentRoomType, roomTypeAmounts.getOrDefault(currentRoomType, 0.0) + eachRoomAmount);
                    }
                }
            }

            reports report = new reports();

            System.out.print(header);
            for (Map.Entry< String, Double> entry : roomTypeAmounts.entrySet()) {
                report.setRoomType(entry.getKey());
                report.setAmount(entry.getValue());
                System.out.print(report.displayByRoomType());
            }
            System.out.println(footer);
        } else {
            double eachRoomAmount = 0;
            double roomTypeAmount = 0;
            reports report = new reports();

            for (guests guest : reservationList) {
                for (rooms room : roomList) {
                    if (room.getRoomType().equalsIgnoreCase(roomType)
                            && room.getRoomId().equals(guest.getDesiredRoomId())) {
                        eachRoomAmount = room.getDailyRate() * guest.getNumOfRentalDays();
                        roomTypeAmount += eachRoomAmount;

                        report.setRoomType(roomType);
                        report.setAmount(roomTypeAmount);
                    }
                }
            }

            System.out.print(header);
            System.out.print(report.displayByRoomType());
            System.out.println(footer);
        }
    }
}
