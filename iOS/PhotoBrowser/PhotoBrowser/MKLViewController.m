//
//  MKLViewController.m
//  PhotoBrowser
//
//  Created by Mark Lewis on 17-1-3.
//  Copyright (c) 2017年 MarkLewis. All rights reserved.
//

#import "MKLViewController.h"

#define kImageIcon @"icon"
#define kImageDescription @"desc"
@interface MKLViewController ()
- (IBAction)leftButtonClicked:(UIButton *)sender;
- (IBAction)rightButtonClicked:(UIButton *)sender;

@property (weak, nonatomic) IBOutlet UIButton *leftButton;
@property (weak, nonatomic) IBOutlet UIButton *rightButton;
@property (weak, nonatomic) IBOutlet UILabel *numLabel;
@property (weak, nonatomic) IBOutlet UIImageView *avatarImageView;
@property (weak, nonatomic) IBOutlet UILabel *descriptionLabel;

/** 当前图片的索引*/
@property (nonatomic) int currentIndex;

/** 图片的字典数组数据*/
@property (nonatomic, strong) NSArray *imagesData;

@end

@implementation MKLViewController


- (void)changeData
{
    // 修改显示当前图片和个数的Label
    self.numLabel.text = [NSString stringWithFormat:@"%d/%d", self.currentIndex+1, self.imagesData.count];
    
    // 取出数据中的字典
    NSDictionary *imageDic = self.imagesData[_currentIndex];
    NSString *imageName = imageDic[kImageIcon];
    self.avatarImageView.image = [UIImage imageNamed:imageName];
    
    // 取出图片的描述数据
    NSString *imageDesc = imageDic[kImageDescription];
    self.descriptionLabel.text = imageDesc;
    
    // 更改按钮的状态
    self.leftButton.enabled = (self.currentIndex != 0);
    self.rightButton.enabled = (self.currentIndex != (self.imagesData.count-1));
}

- (IBAction)leftButtonClicked:(UIButton *)sender
{
    // 上一张图片
    self.currentIndex--;
    [self changeData];
}

- (IBAction)rightButtonClicked:(UIButton *)sender
{
    self.currentIndex++;
    [self changeData];
}
- (NSArray *)imagesData
{
    if(_imagesData == nil)
    {
        // lazy loading
        NSBundle *mainBundle = [NSBundle mainBundle];
        _imagesData = [NSArray arrayWithContentsOfFile:[mainBundle pathForResource:@"imageData" ofType:@"plist"]];
    }
    
    return _imagesData;
}
- (void)viewDidLoad
{
    [super viewDidLoad];
	// Do any additional setup after loading the view, typically from a nib.
    self.currentIndex = 0;
    [self changeData];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}
@end
