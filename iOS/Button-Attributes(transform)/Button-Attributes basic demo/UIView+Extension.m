//
//  UIView+Extension.m
//  Button-Attributes basic demo
//
//  Created by Mark Lewis on 16-12-30.
//  Copyright (c) 2016年 MarkLewis. All rights reserved.
//

#import "UIView+Extension.h"

@implementation UIView (Extension)

//dynamic 什么作用
//@dynamic top;
//@dynamic right;
//@dynamic bottom;
//@dynamic left;

- (void)setTop:(CGFloat)top
{
    //先取出临时的frame
    CGRect tempFrame = self.frame;
    
    // 修改新值
    tempFrame.origin.y = top;
    
    // 赋值回完整的Frame给view的属性
    self.frame = tempFrame;
}
- (CGFloat)top
{
    return self.frame.origin.y;
}

- (void)setBottom:(CGFloat)bottom
{
    CGRect tempFrame = self.frame;
    tempFrame.origin.y = bottom - self.frame.size.height; //加上底部的高度
    self.frame = tempFrame;
}
- (CGFloat)bottom;
{
    return self.frame.origin.y + self.frame.size.height;
}


- (void)setLeft:(CGFloat)left
{
    CGRect tempFrame = self.frame;
    tempFrame.origin.x = left;
    self.frame = tempFrame;
}
- (CGFloat)left
{
    return self.frame.origin.x;
}

- (void)setRight:(CGFloat)right
{
    CGRect tempFrame = self.frame;
    tempFrame.origin.x = right - self.frame.size.width;
    self.frame = tempFrame;
}
-(CGFloat)right
{
    return self.frame.origin.x + self.frame.size.width;
}
@end
