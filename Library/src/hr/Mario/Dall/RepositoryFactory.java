/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.Mario.Dall;

import hr.Mario.Dal.Sql.SQLRepository;

/**
 *
 * @author mario
 */
public  class  RepositoryFactory {

    public RepositoryFactory() {
    }
    
    public static Repository GetRepository(){
        
        return new SQLRepository();
    }

}
