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
                                        "15. Cho biết tên của các phi công lái máy bay Boeing\n"+
                                        "16. Với mỗi loại máy bay có phi công lái cho biết mã số, loại máy báy và tổng số phi công có thể lái loại máy bay đó\n"+
                                        "17. Giả sử một hành khách muốn đi thẳng từ ga A đến ga B rồi quay trở về ga A. Cho biết các đường bay nào có thể đáp ứng yêu cầu này\n"+
                                        "18. Với mỗi ga có chuyến bay xuất phát từ đó cho biết có bao nhiêu chuyến bay khởi hành từ ga đó\n"+
                                        "19. Với mỗi ga có chuyến bay xuất phát từ đó cho biết tổng chi phí phải trả cho phi công lái các chuyến bay khởi hành từ ga đó\n"+
                                        "20. Cho biết danh sách các chuyến bay có thể khởi hành trước 12:00\n"+
                                        "21. Với mỗi địa điểm xuất phát cho biết có bao nhiêu chuyến bay có thể khởi hành trước 12:00\n"+
                                        "22. Cho biết mã số của các phi công chỉ lái được 3 loại máy bay\n"+
                                        "23. Với mỗi phi công có thể lái nhiều hơn 3 loại máy bay, cho biết mã số phi công và tầm bay lớn nhất của các loại máy bay mà phi công đó có thể lái\n"+
                                        "24. Với mỗi phi công cho biết mã số phi công và tổng số loại máy bay mà phi công đó có thể lái\n"+
                                        "25. Tìm các nhân viên không phải là phi công\n"+
                                        "26. Cho biết mã số của các nhân viên có lương cao nhất\n"+
                                        "27. Cho biết tổng số lương phải trả cho các phi công\n"+
                                        "28. Tìm các chuyến bay có thể được thực hiện bởi tất cả các loại máy bay Boeing\n"+
                                        "0. Trở lại\n");
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
                                        planeRepository = new PlaneRepository();
                                        List<Plane> planes = planeRepository.getPlaneSumEmployee();
                                        planes.stream().forEach((e) -> System.out.println("-MaMB: " + e.getPlaneCode() + " -Loai: " + e.getType()
                                                +" -Sum(Employee): "+e.getFlight()));
                                        break;
                                    }
                                    case 17:{
                                        flyRepository = new FlyRepository();
                                        List<Fly> flies = flyRepository.getFlyComeBackA();
                                        flies.stream().forEach(e -> System.out.println("-MaCB: " + e.getFlyCode()
                                                + " -Ga di: " + e.getGaDi() + " -Ga den: " + e.getGaDen() + " -Gio di: "
                                                + e.getGioDi() + " -Gio den: " + e.getGioDen() + " -Do dai: " + e.getDoDai()
                                                + " -Chi phi: " + e.getChiPhi()));
                                        break;
                                    }
                                    case 18:{
                                        flyRepository = new FlyRepository();
                                        List<Fly> flies = flyRepository.getFlySumGaDi();
                                        flies.stream().forEach(e -> System.out.println(" -Ga di: " + e.getGaDi()
                                                + " -So chuyen bay: " + e.getDoDai()));
                                        break;
                                    }
                                    case 19:{
                                        flyRepository = new FlyRepository();
                                        List<Fly> flies = flyRepository.getFlySumChiPhi();
                                        flies.stream().forEach(e -> System.out.println(" -Ga di: " + e.getGaDi()
                                                + " -Tong chi phi: " + e.getDoDai()));
                                        break;
                                    }
                                    case 20:{
                                        flyRepository = new FlyRepository();
                                        List<Fly> flies = flyRepository.getFlyBy12h();
                                        flies.stream().forEach(e -> System.out.println("-MaCB: " + e.getFlyCode()
                                                + " -Ga di: " + e.getGaDi() + " -Ga den: " + e.getGaDen() + " -Gio di: "
                                                + e.getGioDi() + " -Gio den: " + e.getGioDen() + " -Do dai: " + e.getDoDai()
                                                + " -Chi phi: " + e.getChiPhi()));
                                        break;
                                    }
                                    case 21:{
                                        flyRepository = new FlyRepository();
                                        List<Fly> flies = flyRepository.getFlyByGaDi12h();
                                        flies.stream().forEach(e -> System.out.println(" -Ga di: " + e.getGaDi()
                                                + " -Tong chuyen bay truoc 12h: " + e.getDoDai()));
                                        break;
                                    }
                                    case 22:{
                                        certificateRepository = new CertificateRepository();
                                        List<Certification> certifications = certificateRepository.getCertificateOf3PlaneType();
                                        certifications.stream().forEach((e) -> System.out.println("-MaNV: "+ e.getEmpCode()));
                                        break;
                                    }
                                    case 23:{
                                        certificateRepository = new CertificateRepository();
                                        List<Certification> certifications = certificateRepository.getCertificateMoreThan3PlaneType();
                                        certifications.stream().forEach((e) -> System.out.println("-MaNV: "
                                                + e.getEmpCode() + " -Max(TamBay): " + e.getPlaneCode()));
                                        break;
                                    }
                                    case 24:{
                                        certificateRepository = new CertificateRepository();
                                        List<Certification> certifications = certificateRepository.getCertificateAllPlaneType();
                                        certifications.stream().forEach((e) -> System.out.println("-MaNV: "
                                                + e.getEmpCode() + " -Count(Loai): " + e.getPlaneCode()));
                                        break;
                                    }
                                    case 25:{
                                        employeeRepository = new EmployeeRepository();
                                        List<Employee> employee = employeeRepository.getEmployeeNotPilot();
                                        employee.stream().forEach((e) -> System.out.println("-MaNV: " + e.getEmpCode() + " -Ten: "
                                                + e.getName() + " -Luong: " + e.getSalary()));
                                        break;
                                    }
                                    case 26:{
                                        employeeRepository = new EmployeeRepository();
                                        List<Employee> employee = employeeRepository.getEmployeeMaxSalary();
                                        employee.stream().forEach((e) -> System.out.println("-MaNV: " + e.getEmpCode() + " -Ten: "
                                                + e.getName() + " -Luong: " + e.getSalary()));
                                        break;
                                    }
                                    case 27:{
                                        employeeRepository = new EmployeeRepository();
                                        System.out.println("Sum: " + employeeRepository.getEmployeeSumSalaryIsPilot());
                                        break;
                                    }
                                    case 28:{
                                        flyRepository = new FlyRepository();
                                        List<Fly> flies = flyRepository.getFlyByAllBoeing();
                                        flies.stream().forEach(e -> System.out.println("-MaCB: " + e.getFlyCode()
                                                + " -Ga di: " + e.getGaDi() + " -Ga den: " + e.getGaDen() + " -Gio di: "
                                                + e.getGioDi() + " -Gio den: " + e.getGioDen() + " -Do dai: " + e.getDoDai()
                                                + " -Chi phi: " + e.getChiPhi()));
                                        break;
                                    }
                                    case 0:{
                                        break;
                                    }
                                }
                            } while (sub != 0);
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
