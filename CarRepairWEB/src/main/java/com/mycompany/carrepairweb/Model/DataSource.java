package com.mycompany.carrepairweb.Model;
import java.util.List;
/**
 *
 * @author mateu
 */
public interface DataSource {
    public List<Job> getJobs();
    public void persistObject(Object object);
    public boolean update(Job job);
    public boolean delete(int id);
}
