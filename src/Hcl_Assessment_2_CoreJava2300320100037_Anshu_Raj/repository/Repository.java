package Hcl_Assessment_2_CoreJava2300320100037_Anshu_Raj.repository;

public interface Repository <T,Id>{

    void SaveItem(T item);
    void DeleteItem(T item);
    void findByname(T item);
    
}
