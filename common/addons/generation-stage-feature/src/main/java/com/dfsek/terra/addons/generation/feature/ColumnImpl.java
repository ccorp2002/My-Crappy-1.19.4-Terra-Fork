/*
 * Copyright (c) 2020-2021 Polyhedral Development
 *
 * The Terra Core Addons are licensed under the terms of the MIT License. For more details,
 * reference the LICENSE file in this module's root directory.
 */

package com.dfsek.terra.addons.generation.feature;

import java.util.function.IntConsumer;

import com.dfsek.terra.api.block.state.BlockState;
import com.dfsek.terra.api.structure.feature.BinaryColumn;
import com.dfsek.terra.api.world.chunk.generation.util.Column;
import com.dfsek.terra.api.world.WritableWorld;


public class ColumnImpl<T extends WritableWorld> implements Column<T> {
    private final int x;
    private final int z;
    private final T world;
    
    public ColumnImpl(int x, int z, T world) {
        this.x = x;
        this.z = z;
        this.world = world;
    }
    
    @Override
    public int getX() {
        return x;
    }
    
    @Override
    public int getZ() {
        return z;
    }
    
    @Override
    public BlockState getBlock(int y) {
        return world.getBlockData(x, y, z);
    }
    
    @Override
    public T getWorld() {
        return world;
    }
    
    @Override
    public int getMinY() {
        return world.getMinHeight();
    }
    
    @Override
    public int getMaxY() {
        return world.getMaxHeight();
    }
    
    @Override
    public void forEach(IntConsumer function) {
        for(int y = world.getMinHeight(); y < world.getMaxHeight(); y++) {
            function.accept(y);
        }
    }
    
    @Override
    public BinaryColumn newBinaryColumn() {
        return new BinaryColumn(getMinY(), getMaxY());
    }
}
