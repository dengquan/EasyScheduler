/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.escheduler.common.task.spark;

import cn.escheduler.common.enums.ProgramType;
import cn.escheduler.common.process.ResourceInfo;
import cn.escheduler.common.task.AbstractParameters;

import java.util.List;
import java.util.stream.Collectors;

/**
 * spark parameters
 */
public class SparkParameters extends AbstractParameters {

  /**
   * major jar
   */
  private ResourceInfo mainJar;

  /**
   * major class
   */
  private String mainClass;

  /**
   * deploy mode
   */
  private String deployMode;

  /**
   * master
   */
  private String master;

  /**
   * arguments
   */
  private String mainArgs;

  /**
   * driver-cores Number of cores used by the driver, only in cluster mode
   */
  private int driverCores;

  /**
   * driver-memory Memory for driver
   */

  private String driverMemory;

  /**
   * total-executor-cores Number of all executor cores
   */
  private int totalExecutorCores;

  /**
   * Memory per executor
   */
  private String executorMemory;

  /**
   * Cores per executor
   */
  private int executorCores;

  /**
   * resource list
   */
  private List<ResourceInfo> resourceList;

  /**
   * The YARN queue to submit to
   */
  private String queue;

  /**
   * other arguments
   */
  private String others;

  /**
   * program type
   * 0 JAVA,1 SCALA,2 PYTHON
   */
  private ProgramType programType;

  public ResourceInfo getMainJar() {
    return mainJar;
  }

  public void setMainJar(ResourceInfo mainJar) {
    this.mainJar = mainJar;
  }

  public String getMainClass() {
    return mainClass;
  }

  public void setMainClass(String mainClass) {
    this.mainClass = mainClass;
  }

  public String getDeployMode() {
    return deployMode;
  }

  public void setDeployMode(String deployMode) {
    this.deployMode = deployMode;
  }

  public String getMaster() {
    return master;
  }

  public void setMaster(String master) {
    this.master = master;
  }

  public String getMainArgs() {
    return mainArgs;
  }

  public void setMainArgs(String mainArgs) {
    this.mainArgs = mainArgs;
  }

  public int getDriverCores() {
    return driverCores;
  }

  public void setDriverCores(int driverCores) {
    this.driverCores = driverCores;
  }

  public String getDriverMemory() {
    return driverMemory;
  }

  public void setDriverMemory(String driverMemory) {
    this.driverMemory = driverMemory;
  }

  public int getTotalExecutorCores() {
    return totalExecutorCores;
  }

  public void setTotalExecutorCores(int totalExecutorCores) {
    this.totalExecutorCores = totalExecutorCores;
  }

  public String getExecutorMemory() {
    return executorMemory;
  }

  public void setExecutorMemory(String executorMemory) {
    this.executorMemory = executorMemory;
  }

  public int getExecutorCores() {
    return executorCores;
  }

  public void setExecutorCores(int executorCores) {
    this.executorCores = executorCores;
  }

  public String getQueue() {
    return queue;
  }

  public void setQueue(String queue) {
    this.queue = queue;
  }

  public List<ResourceInfo> getResourceList() {
    return resourceList;
  }

  public void setResourceList(List<ResourceInfo> resourceList) {
    this.resourceList = resourceList;
  }

  public String getOthers() {
    return others;
  }

  public void setOthers(String others) {
    this.others = others;
  }

  public ProgramType getProgramType() {
    return programType;
  }

  public void setProgramType(ProgramType programType) {
    this.programType = programType;
  }

  @Override
  public boolean checkParameters() {
    return mainJar != null && programType != null;
  }


  @Override
  public List<String> getResourceFilesList() {
    if(resourceList !=null ) {
      this.resourceList.add(mainJar);
      return resourceList.stream()
              .map(p -> p.getRes()).collect(Collectors.toList());
    }
    return null;
  }


}
