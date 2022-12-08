import java.util.List;
import java.util.Scanner;

import entity.Certification;
import entity.Employee;
import entity.Fly;
import entity.Plane;
import repository.CertificateRepository;
import repository.EmployeeRepository;
import repository.FlyRepository;
import repository.PlaneRepository;

    public class Main {
        public Main() {
        }

        public static void main(String[] args) {
            try {
                Scanner scanner = new Scanner(System.in);
                int choice;
                do {
                    System.out.println("---------------------MENU--------------------");
                    System.out.println("1. Xem danh sách nhân viên\n2. Xem danh sách chuyến bay\n3. Xem danh sách chứng nhận\n" +
                            "4. Xem danh sách máy bay\n5. Thêm mới nhân viên\n6. Thoát\n0. Một số chức năng yêu cầu");
                    System.out.print("Enter choice: ");
                    choice = scanner.nextInt();
                    EmployeeRepository employeeRepository;
                    FlyRepository flyRepository;
                    PlaneRepository planeRepository;
                    CertificateRepository certificateRepository;
                    switch (choice) {
                        case 0: {
                            int sub;
                            do {
                                System.out.println("-----------------------------------------------------------");
                                System.out.println("1. Cho biết các chuyến bay đi Đà Lạt (DAD)\n" +
                                        "2. Cho biết các loại máy bay có tầm bay lớn hơn 10,000km\n" +
                                        "3. Tìm các nhân viên có lương nhỏ hơn 10,000\n" +
                                        "4. Cho biết các chuyến bay có độ dài đường bay nhỏ hơn 10.000km và lớn hơn 8.000km\n" +
                                        "5. Cho biết các chuyến bay xuất phát từ Sài Gòn (SGN) đi Ban Mê Thuộc (BMV)\n" +
                                        "6. Có bao nhiêu chuyến bay xuất phát từ Sài Gòn (SGN)\n" +
                                        "7. Có bao nhiêu loại máy báy Boeing\n8. Cho biết tổng số lương phải trả cho các nhân viên\n" +
                                        "9. Cho biết mã số của các phi công lái máy báy Boeing\n" +
                                        "10. Cho biết các nhân viên có thể lái máy bay có mã số 747\n" +
                                        "11. Cho biết mã số của các loại máy bay mà nhân viên có họ Nguyễn có thể lái\n" +
                                        "12. Cho biết mã số của các phi công vừa lái được Boeing vừa lái được Airbus\n" +
                                        "13. Cho biết các loại máy bay có thể thực hiện chuyến bay VN280\n" +
                                        "14. Cho biết các chuyến bay có thể ñược thực hiện bởi máy bay Airbus A320\n" +
                                        "15. Cho biết tên của các phi công lái máy bay Boeing\n16. Trở lại");
                                System.out.print("Enter :");
                                sub = scanner.nextInt();
                                switch (sub) {
                                    case 1: {
                                        flyRepository = new FlyRepository();
                                        List<Fly> flies = flyRepository.getFlyByDAD();
                                        flies.stream().forEach(e -> System.out.println("-MaCB: " + e.getFlyCode()
                                                + " -Ga di: " + e.getGaDi() + " -Ga den: " + e.getGaDen() + " -Gio di: "
                                                + e.getGioDi() + " -Gio den: " + e.getGioDen() + " -Do dai: " + e.getDoDai()
                                                + " -Chi phi: " + e.getChiPhi()));
                                        break;
                                    }
                                    case 2: {
                                        planeRepository = new PlaneRepository();
                                        List<Plane> planes = planeRepository.getPlaneByTamBay10000();
                                        planes.stream().forEach((e) -> System.out.println("-MaMB: " + e.getPlaneCode() + " -TamBay: " + e.getFlight()
                                                + " -Loai: " + e.getType()));
                                        break;
                                    }
                                    case 3: {
                                        employeeRepository = new EmployeeRepository();
                                        List<Employee> employee = employeeRepository.getEmployeeSalary10000();
                                        employee.stream().forEach((e) -> System.out.println("-MaNV: " + e.getEmpCode() + " -Ten: "
                                                + e.getName() + " -Luong: " + e.getSalary()));
                                        break;
                                    }
                                    case 4: {
                                        flyRepository = new FlyRepository();
                                        List<Fly> flies = flyRepository.getFlyByDoDai();
                                        flies.stream().forEach(e -> System.out.println("-MaCB: " + e.getFlyCode()
                                                + " -Ga di: " + e.getGaDi() + " -Ga den: " + e.getGaDen() + " -Gio di: "
                                                + e.getGioDi() + " -Gio den: " + e.getGioDen() + " -Do dai: " + e.getDoDai()
                                                + " -Chi phi: " + e.getChiPhi()));
                                        break;
                                    }
                                    case 5: {
                                        flyRepository = new FlyRepository();
                                        List<Fly> flies = flyRepository.getFlyToGaDiFromGaDen();
                                        flies.stream().forEach(e -> System.out.println("-MaCB: " + e.getFlyCode()
                                                + " -Ga di: " + e.getGaDi() + " -Ga den: " + e.getGaDen() + " -Gio di: "
                                                + e.getGioDi() + " -Gio den: " + e.getGioDen() + " -Do dai: " + e.getDoDai()
                                                + " -Chi phi: " + e.getChiPhi()));
                                        break;
                                    }
                                    case 6: {
                                        flyRepository = new FlyRepository();
                                        List<Fly> flies = flyRepository.getFlyBySGN();
                                        flies.stream().forEach(e -> System.out.println("-MaCB: " + e.getFlyCode()
                                                + " -Ga di: " + e.getGaDi() + " -Ga den: " + e.getGaDen() + " -Gio di: "
                                                + e.getGioDi() + " -Gio den: " + e.getGioDen() + " -Do dai: " + e.getDoDai()
                                                + " -Chi phi: " + e.getChiPhi()));
                                        break;
                                    }
                                    case 7: {
                                        planeRepository = new PlaneRepository();
                                        List<Plane> planes = planeRepository.getPlaneOfType();
                                        planes.stream().forEach((e) -> System.out.println("-MaMB: " + e.getPlaneCode() + " -TamBay: " + e.getFlight()
                                                + " -Loai: " + e.getType()));
                                        break;
                                    }
                                    case 8: {
                                        employeeRepository = new EmployeeRepository();
                                        System.out.println("Sum: " + employeeRepository.getSumSalary());
                                        break;
                                    }
                                    case 9: {
                                        certificateRepository = new CertificateRepository();
                                        List<Certification> certifications = certificateRepository.getCertificateNV();
                                        certifications.stream().forEach((e) -> System.out.println("-MaNV: "
                                                + e.getEmpCode() + " -MaMB: " + e.getPlaneCode()));
                                        break;
                                    }
                                    case 10: {
                                        employeeRepository = new EmployeeRepository();
                                        List<Employee> employee = employeeRepository.getEmployeePlaneCode747();
                                        employee.stream().forEach((e) -> System.out.println("-MaNV: " + e.getEmpCode() + " -Ten: "
                                                + e.getName() + " -Luong: " + e.getSalary()));
                                        break;
                                    }
                                    case 11: {
                                        certificateRepository = new CertificateRepository();
                                        List<Certification> certifications = certificateRepository.getCertificateOfNguyen();
                                        certifications.stream().forEach((e) -> System.out.println("-MaNV: "
                                                + e.getEmpCode() + " -MaMB: " + e.getPlaneCode()));
                                        break;
                                    }
                                    case 12: {
                                        certificateRepository = new CertificateRepository();
                                        List<Certification> certifications = certificateRepository.getCertificateNVs();
                                        certifications.stream().forEach((e) -> System.out.println("-MaNV: "
                                                + e.getEmpCode() + " -MaMB: " + e.getPlaneCode()));
                                        break;
                                    }
                                    case 13: {
                                        planeRepository = new PlaneRepository();
                                        List<Plane> planes = planeRepository.getPlaneByVN280();
                                        planes.stream().forEach((e) -> System.out.println("-MaMB: " + e.getPlaneCode() + " -TamBay: " + e.getFlight()
                                                + " -Loai: " + e.getType()));
                                        break;
                                    }
                                    case 14: {
                                        flyRepository = new FlyRepository();
                                        List<Fly> flies = flyRepository.getFlyByAirbusA320();
                                        flies.stream().forEach(e -> System.out.println("-MaCB: " + e.getFlyCode()
                                                + " -Ga di: " + e.getGaDi() + " -Ga den: " + e.getGaDen() + " -Gio di: "
                                                + e.getGioDi() + " -Gio den: " + e.getGioDen() + " -Do dai: " + e.getDoDai()
                                                + " -Chi phi: " + e.getChiPhi()));
                                        break;
                                    }
                                    case 15: {
                                        employeeRepository = new EmployeeRepository();
                                        List<Employee> employee = employeeRepository.getEmployeeBoeing();
                                        employee.stream().forEach((e) -> System.out.println("-MaNV: " + e.getEmpCode() + " -Ten: "
                                                + e.getName() + " -Luong: " + e.getSalary()));
                                        break;
                                    }
                                    case 16: {
                                        break;
                                    }
                                }
                            } while (sub != 16);
                            break;
                        }
                        case 1:{
                            employeeRepository = new EmployeeRepository();
                            List<Employee> employee = employeeRepository.getAllEmployee();
                            employee.stream().forEach((e) -> System.out.println("-MaNV: " + e.getEmpCode() + " -Ten: "
                                    + e.getName() + " -Luong: " + e.getSalary()));
                            break;
                            }
                        case 2: {
                            flyRepository = new FlyRepository();
                            List<Fly> flies = flyRepository.getAllFly();
                            flies.stream().forEach(e -> System.out.println("-MaCB: " + e.getFlyCode()
                                    + " -Ga di: " + e.getGaDi() + " -Ga den: " + e.getGaDen() + " -Gio di: "
                                    + e.getGioDi() + " -Gio den: " + e.getGioDen() + " -Do dai: " + e.getDoDai()
                                    + " -Chi phi: " + e.getChiPhi()));
                            break;
                        }
                        case 3: {
                            certificateRepository = new CertificateRepository();
                            List<Certification> certifications = certificateRepository.getAllCertificate();
                            certifications.stream().forEach((e) -> System.out.println("-MaNV: "
                                    + e.getEmpCode() + " -MaMB: " + e.getPlaneCode()));
                            break;
                        }
                        case 4: {
                            planeRepository = new PlaneRepository();
                            List<Plane> planes = planeRepository.getAllPlane();
                            planes.stream().forEach((e) -> System.out.println("-MaMB: " + e.getPlaneCode() + " -TamBay: " + e.getFlight()
                                    + " -Loai: " + e.getType()));
                            break;
                        }
                        case 5: {
                            employeeRepository = new EmployeeRepository();
                            scanner.nextLine();
                            System.out.print("Code: ");
                            String empCode = scanner.nextLine();
                            System.out.print("Name: ");
                            String name = scanner.nextLine();
                            System.out.print("Salary: ");
                            int salary = scanner.nextInt();
                            employeeRepository.setEmployee(empCode, name, salary);
                            break;
                        }
                        case 6:
                            System.out.println("Good bye!!!");
                    }
                } while (choice != 6);
                } catch (Exception ex){
                    System.err.println(ex.getMessage());
                }
    }
}
