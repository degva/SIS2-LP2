package com.grupox.pokemonv.controller.menu;

import com.grupox.pokemonv.controller.Font;
import com.grupox.pokemonv.controller.InputHandler;
import com.grupox.pokemonv.model.Tile;
import java.awt.Graphics2D;

public class DoubleColumnMenu extends Menu{
    
    /* Attributes */
    private int leftColumnMaxLen;
    private final int space = 3;    // Space between columns in characters units. Should consider '>' icon

    /* Constructors */
    public DoubleColumnMenu(InputHandler input, int topOffset, int rightOffset) {
        super( input, topOffset, rightOffset );
    }

    /* Methods */
    @Override
    public void tick() {
        if ( input.up.isFirstPressed && selectedIndex > 1){
            items.get( selectedIndex ).isSelected = false;
            selectedIndex -= 2;
            items.get( selectedIndex ).isSelected = true;
        }else if ( input.down.isFirstPressed && selectedIndex < items.size() - 2){
            items.get( selectedIndex ).isSelected = false;
            selectedIndex += 2;
            items.get( selectedIndex ).isSelected = true;
        }else if ( input.left.isFirstPressed && (selectedIndex & 1) == 1){
            items.get( selectedIndex ).isSelected = false;
            selectedIndex--;
            items.get( selectedIndex ).isSelected = true;
        }else if ( input.right.isFirstPressed && (selectedIndex & 1) == 0 && selectedIndex + 1 < items.size() ){
            items.get( selectedIndex ).isSelected = false;
            selectedIndex++;
            items.get( selectedIndex ).isSelected = true;
        }
    }
    
    @Override
    protected void drawMenuItems( Graphics2D g ) {
        int x1 = leftOffset + Tile.spriteWidthOut, x2 = x1 + (space + leftColumnMaxLen) * Font.fontWidthOut;
        int y = topOffset + Tile.spriteHeightOut;
        for( int i = 0; i < items.size(); i++, y += Tile.spriteHeightOut ){
            items.get( i ).render( g, x1, y );  // Left column
            if( ++i < items.size() ){ //; If there is another item
                items.get( i ).render( g, x2, y );    // Right column
            }
        }
    }
    
    @Override
    protected int getMaxLen(){
        int leftColMaxLen = 0, rightColMaxLen = 0;
        
        // Left Column maxLen
        for( int i = 0; i < items.size(); i++ ){
            // If 'i' is pair, it goes to the left column max
            if ( ( i & 1 ) == 0 ){
                if( items.get( i ).length() > leftColMaxLen ){
                    leftColMaxLen = items.get( i ).length();
                }
            }else{
                if( items.get( i ).length() > rightColMaxLen ){
                    rightColMaxLen = items.get( i ).length();
                }
            }   
        }
        leftColumnMaxLen = leftColMaxLen;
        return leftColMaxLen + rightColMaxLen + space;
    }

    @Override
    protected int getMaxRows() {
        return ( items.size() & 1 ) == 0 ? items.size() / 2 : items.size() / 2 + 1;
    }    
}