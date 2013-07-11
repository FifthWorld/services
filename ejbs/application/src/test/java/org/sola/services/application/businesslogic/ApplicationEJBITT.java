/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sola.services.application.businesslogic;

import java.util.List;
import org.junit.After;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.sola.services.common.test.AbstractEJBTest;
import org.sola.services.ejb.application.businesslogic.ApplicationEJB;
import org.sola.services.ejb.application.businesslogic.ApplicationEJBLocal;
import org.sola.services.ejb.application.repository.entities.CapacityType;
import org.sola.services.ejb.application.repository.entities.DevelopmentStageType;

/**
 *
 * @author WandeChris
 */
public class ApplicationEJBITT extends AbstractEJBTest{
   
    public ApplicationEJBITT() {
        super();
    }

       @Before
    public void setUp() throws Exception {
        
    }

    @After
    public void tearDown() throws Exception {
        
    }
    /**
     * Test method to get client types.
     */
    @Test
    public void testGetCapacityTypes() throws Exception {
        System.out.println(">>> Trying to get capacity types.");

        try {
            ApplicationEJBLocal instance = (ApplicationEJBLocal) getEJBInstance(ApplicationEJB.class.getSimpleName());
            List<CapacityType> result = instance.getCapacityTypes("en");
            assertNotNull("Capacity types not found.", result);
            System.out.println(">>> Found " + result.size() + " capacity types");

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    @Test
    public void testGetDevelopmentStageTypes() throws Exception {
        System.out.println(">>> Trying to get development stage types.");

        try {
            ApplicationEJBLocal instance = (ApplicationEJBLocal) getEJBInstance(ApplicationEJB.class.getSimpleName());
            List<DevelopmentStageType> result = instance.getDevelopmentStageTypes("en");
            assertNotNull("Development stage types not found.", result);
            System.out.println(">>> Found " + result.size() + " development stage  types");

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
