/**
 * Copyright (C) 2010 PROCESSBASE Ltd.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2.0 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.processbase.util.db;
// Generated 13.12.2009 22:19:20 by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * PbProcessAcl generated by hbm2java
 */
@Entity
@Table(name="PB_PROCESS_ACL"
    , uniqueConstraints = @UniqueConstraint(columnNames={"PROCCESS_UUID", "GROUP_DN"}) 
)
public class PbProcessAcl  implements java.io.Serializable {


     private long id;
     private String proccessUuid;
     private String groupDn;

    public PbProcessAcl() {
    }

    public PbProcessAcl(String proccessUuid, String groupDn) {
       this.proccessUuid = proccessUuid;
       this.groupDn = groupDn;
    }
   
     @Id 
    
    @Column(name="ID", unique=true, nullable=false, precision=16, scale=0)
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name="PROCCESS_UUID", nullable=false, length=1000)
    public String getProccessUuid() {
        return this.proccessUuid;
    }
    
    public void setProccessUuid(String proccessUuid) {
        this.proccessUuid = proccessUuid;
    }
    
    @Column(name="GROUP_DN", nullable=false, length=1000)
    public String getGroupDn() {
        return this.groupDn;
    }
    
    public void setGroupDn(String groupDn) {
        this.groupDn = groupDn;
    }




}

