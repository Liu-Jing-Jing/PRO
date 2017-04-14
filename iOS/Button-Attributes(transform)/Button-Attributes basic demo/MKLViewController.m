//
//  MKLViewController.m
//  Button-Attributes basic demo
//
//  Created by Mark Lewis on 16-12-30.
//  Copyright (c) 2016年 MarkLewis. All rights reserved.
//

#import "MKLViewController.h"
#import "UIView+Extension.h"
@interface MKLViewController ()
@property (weak, nonatomic) IBOutlet UIButton *avatarButton;

- (IBAction)movementAction:(UIButton *)sender;
@end

@implementation MKLViewController

- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - 移动按钮的方法
// tag 上10 右20 下30 左40

#warning bug
- (IBAction)movementAction:(UIButton *)sender
{
    [UIView beginAnimations:@"1" context:NULL];
    [UIView setAnimationDuration:1.0];
    
    switch (sender.tag)
    {
        case 10:
            sender.transform = CGAffineTransformTranslate(sender.transform, 0, -20);
            break;
        case 20:
            sender.transform = CGAffineTransformTranslate(sender.transform, 20, 0); // 右
            break;
        case 30:
            sender.transform = CGAffineTransformTranslate(sender.transform, 0, 20); //下
            break;
        case 40:
            sender.transform = CGAffineTransformTranslate(sender.transform, -20, 0); //左
            break;
        default:
            break;
    }
    [UIView commitAnimations];
}

# pragma mark - 合并放大和缩小的事件方法
- (IBAction)scaleButtinSize:(UIButton *)sender
{
    CGRect tempBounds = self.avatarButton.frame;
    switch (sender.tag)
    {
        case 50:// 放大
            tempBounds.size.width += 20;
            tempBounds.size.height += 20;
            break;
        case 60:// 缩小
            tempBounds.size.width -= 20;
            tempBounds.size.height -= 20;
            break;
        default:
            break;
    }
    
    [UIView animateWithDuration:1.0 animations:^{
        self.avatarButton.bounds = tempBounds;
    }];
}

- (IBAction)bigger
{

}

- (IBAction)smaller
{
    CGRect tempBounds = self.avatarButton.bounds;
    tempBounds.size.width -= 20;
    tempBounds.size.height -= 20;
    self.avatarButton.bounds = tempBounds;
}
@end
