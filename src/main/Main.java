package main;

import java.util.Date;
import java.util.List;
import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.dao.SellerDAO;
import model.domain.Department;
import model.domain.Seller;

/**
 *
 * @author joana
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("========= Seller tests =========");
        
        SellerDAO sellerDAO = DAOFactory.createSellerDAO();
        System.out.println(" -- TESTE 1: seller findyById ---");
        Seller seller = sellerDAO.findById(3);
        System.out.println(seller);
        
        System.out.println("\n -- TESTE 2: seller findyByDepartment ---");
        Department dep = new Department(2, null);
        List<Seller> sellers = sellerDAO.findByDepartment(dep);
        for(Seller s : sellers){
            System.out.println(s);
        }
        
        System.out.println("\n -- TESTE 3: seller findyAll ---");
        sellers = sellerDAO.findAll();
        for(Seller s : sellers){
            System.out.println(s);
        }
        
        System.out.println("\n -- TESTE 4: seller insert ---");
        Seller newSeller = new Seller(0, "Greg", "greg@gmail.com", new Date(), 4000.00, dep);
        sellerDAO.insert(newSeller);
        System.out.println("Inserted! New id: " + newSeller.getId());
        
        System.out.println("\n -- TESTE 5: seller update: ---");
        seller = sellerDAO.findById(1);
        seller.setName("Martha Waine");
        seller.setEmail("martha@gmail.com");
        sellerDAO.update(seller);
        System.out.println("Update completed.");
        
        System.out.println("\n -- TESTE 6: seller delete ---");
        sellerDAO.deleteById(7);
        System.out.println("Delete completed");

        System.out.println("========= Department tests =========");
        DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();

        System.out.println(" -- TEST 1: department findById --");
        dep = departmentDAO.findById(1);
        System.out.println(dep);

        System.out.println("\n -- TEST 2: department findAll --");
        List<Department> list = departmentDAO.findAll();
        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println("\n -- TEST 3: department insert --");
        Department newDepartment = new Department(null, "Music");
        departmentDAO.insert(newDepartment);
        System.out.println("Inserted! New id: " + newDepartment.getId());

        System.out.println("\n -- TEST 4: department update --");
        Department dep2 = departmentDAO.findById(1);
        dep2.setName("Food");
        departmentDAO.update(dep2);
        System.out.println("Update completed");

        System.out.println("\n -- TEST 5: department delete --");
        departmentDAO.deleteById(4);
        System.out.println("Delete completed");
    }
}